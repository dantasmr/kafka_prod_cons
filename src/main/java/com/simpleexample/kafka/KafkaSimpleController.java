package com.simpleexample.kafka;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaSimpleController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;

    @Autowired
    public KafkaSimpleController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel){
        kafkaTemplate.send("mytopic", jsonConverter.toJson(simpleModel));
    }

   @PostMapping("/v2")
    public void post(@RequestBody TitleModel titleModel){
        kafkaTemplate.send("xpto", jsonConverter.toJson(titleModel));
    }


   @KafkaListener(topics = "mytopic")
    public void getFromKafka(String simpleModel){
        SimpleModel simpleModelObject =  jsonConverter.fromJson(simpleModel, SimpleModel.class);
        System.out.println(simpleModel.toString());
    }

    @KafkaListener(topics = "xpto")
    public void getFromKafkafka2(String titleModel){
        TitleModel titleModel1 =  jsonConverter.fromJson(titleModel, TitleModel.class);
        System.out.println(titleModel1.toString());
    }
}
