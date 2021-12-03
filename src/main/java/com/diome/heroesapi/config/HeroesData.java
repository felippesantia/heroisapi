package com.diome.heroesapi.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.diome.heroesapi.constants.HeroesConstant.REGION_DYNAMO;
import static com.diome.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;


public class HeroesData {
    public static void main (String [] args) throws Exception{

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero = new Item()
                .withPrimaryKey("id", 2)
                .withString("name", "Homem-Aranha")
                .withString("universe","Marvel")
                .withNumber("films", 7);

        Item hero2 = new Item()
                .withPrimaryKey("id", 3)
                .withString("name", "Batman")
                .withString("universe","dc comics")
                .withNumber("films", 5);

        Item hero3 = new Item()
                .withPrimaryKey("id", 4)
                .withString("name", "Hulk")
                .withString("universe","Marvel")
                .withNumber("films", 6);

        PutItemOutcome outcome1 = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);



    }
}
