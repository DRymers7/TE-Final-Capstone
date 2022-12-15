//package com.techelevator.model.CustomSerializer;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.ser.std.StdSerializer;
//import com.techelevator.model.ModelClasses.Azure.Inputs;
//import com.techelevator.model.ModelClasses.Azure.trash.UserInfoPrediction;
//import com.techelevator.model.ModelClasses.Azure.data;
//
//import java.io.IOException;
//
//public class AzureSerializer extends StdSerializer<data> {
//
//    public AzureSerializer() {
//        this(null);
//    }
//
//    public AzureSerializer(Class<UserInfoPrediction> userInfoPredictionClass) {
//        super(userInfoPredictionClass);
//    }
//
//    @Override
//    public void serialize(data data, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeFieldName("Input");
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeFieldName("data");
//        jsonGenerator.writeObject(value.getInputs().getData());
//        jsonGenerator.writeFieldName("Insulin");
//        jsonGenerator.writeNumber(String.valueOf(value.getInputs().getdata());
//        jsonGenerator.writeFieldName("BMI");
//        jsonGenerator.writeFieldName("Age");
//        jsonGenerator.writeFieldName("Outcome");
//        jsonGenerator.writeEndObject();
////        jsonGenerator.writeObject(value.getInputs());
////        jsonGenerator.writeStartObject();
////        jsonGenerator.writeStartArray();
////        jsonGenerator.writeStartObject();
////        jsonGenerator.writeObject(value.getInputs().getData());
////        jsonGenerator.writeNumber("Insulin");
////        jsonGenerator.writeNumber("BMI");
////        jsonGenerator.writeNumber("Age");
////        jsonGenerator.writeNumber("Outcome");
////        jsonGenerator.writeEndObject();
////        jsonGenerator.writeEndArray();
////        jsonGenerator.writeEndObject();
////        jsonGenerator.writeNumber(value.getGlobalParameters());
////        jsonGenerator.writeEndObject();
//    }
//}
