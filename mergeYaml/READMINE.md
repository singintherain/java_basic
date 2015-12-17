# 合并多个yaml文件

yaml是一个简单的文件格式，区别与java原生的properties类型，它可以存储简单的数据结构，
例如数组、list等，并且解析时可以将输入流转换为指定的类；操作灵活，比xml格式简单，
表达能力强，我一般用它来存储一些自定义的配置。

## 条件

* 所有的文件在同一个目录下
* 目录下有很多不同的文件夹和yaml文件

## 目标

* 将目录下得所有yaml后缀的文件读取
* 提供一个统一的yaml数据获取方式

## 知识点

* yaml load文件后的返回值类型是Object，如何访问内部数据
* 因为本人有过ruby的变成经验，在ruby中对yaml文件load后，使用是非常灵活的，例如：

```
**配置文件内容**
buyer:
  login:
     username:
       xpath: 'asdfasfd'

**解析后，使用**
GUI.buyer.login.username.xpath(GUI为最终保存的所有配置信息)
```

但是，发现在Java中无法做到这一点；如何按照以上的格式定义内容，数据层级是无法预测的；
而Jyaml在load完成数据的返回值是Object类型，此时需要做强制类型转换；由于数据层级无法预测，转换的类型也无法预测；默认情况下是HashMap<String, List<String>>，如果yaml内容
嵌套多层，此时的list<String>就不适用了。

* 不得不多，静态语言确实不擅长配置文件的解析和使用
* 没办法只能自定义类，采用load(file, MyClass.class)的方式来加载内容了；但是，这样就无法提供一个统一的数据解析方案
* 退而求其次，文档解析采用默认的数据类型转换
  - 本来想出来一个set+map的数据结构，赶紧去查了下，发现自己的数据结构已然落伍太多了，需要恶补下
  - java的HashSet，非key/value数据结构；Hash结构数据尽量不要遍历，代价有点高，存取方便。所谓的set，即保证数据是唯一的，因此在向HashSet中保存同样的数据时，会出现错误。
  - Map数据结构是1V1的，不允许有重复的key，一个key最多有一个value

  ```
    static{
        HashMap<String, HashMap<String, HashMap<String, String>>> content;
        System.out.println("config static");
        for(InputStream inputStream : Resources.inputStreams){
            content = (HashMap<String, HashMap<String, HashMap<String, String>>>)Yaml.load(inputStream);
            for(String key1 : content.keySet()){
                System.out.println(key1);
                HashMap<String, HashMap<String, String>> headContent = content.get(key1);
                for(String key2 : headContent.keySet()){
                    HashMap<String, String> content2 = headContent.get(key2);
                    for(String key3 : content2.keySet()){
                        System.out.println(content2.get(key3));
                    }
                }
            }
            System.out.println(content.keySet().size());
            }
  ```

  如上所示，解析的数据结构太过复杂，而且不可控制，改方法不可取

* 采用自定义对象的方式，存储yaml配置文件内容；
  - 这样需要有很强的约束条件
    - 指定的文件对应指定的类
    - 前期需要分配好文件的职责，将同一类型的配置放置在一个文件里
  - 这样不存在文件合并的问题
  - 明显，这种方式有很大的局限性，如果以后配置越来越多，无法扩展

## 实现

* 递归的将指定目录下得所有yaml文件读取
* 
