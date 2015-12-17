package lvsong.club;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

import java.util.Map;

/**
 * Created by lvsong on 11/30/15.
 */
public class HelloWorldBolt extends BaseRichBolt {
    private int myCount = 0;
    private OutputCollector outputCollector;

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.outputCollector = outputCollector;
    }

    public void execute(Tuple tuple) {
        String test = tuple.getStringByField("sentence");
        if("Hello World".equals(test)) {
            myCount++;
            System.out.println("Found a Hellow World! My Count is now : " + Integer.toString(myCount));
        }

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    }
}
