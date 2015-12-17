package lvsong.club;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

/**
 * Created by lvsong on 11/30/15.
 */
public class HelloWorldSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private static final int MAX_RANDOM = 10;
    private int referenceRandom;

    public HelloWorldSpout() {
        final Random random = new Random();
        referenceRandom = random.nextInt(MAX_RANDOM);
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("sentence"));
    }

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
    }

    public void nextTuple() {
        Utils.sleep(100);
        final  Random random = new Random();
        int instanceRandom = random.nextInt(MAX_RANDOM);
        if(instanceRandom == referenceRandom) {
            collector.emit(new Values("Hello World"));
        } else {
            collector.emit(new Values("Other Random Word"));
        }
    }
}
