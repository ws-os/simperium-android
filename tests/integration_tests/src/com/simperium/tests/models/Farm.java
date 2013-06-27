package com.simperium.tests.models;

import com.simperium.client.Bucket;
import com.simperium.client.BucketObject;
import com.simperium.client.BucketSchema;

import java.util.Map;

public class Farm extends BucketObject {
    public static String BUCKET_NAME="farm";

    public static class Schema implements BucketSchema<Farm> {
        private String suffix = "";
        private String remoteName = Farm.BUCKET_NAME;
        public Schema(){
            super();
        }
        public Schema(String suffix){
            remoteName = String.format("%s%s", remoteName, suffix);
        }
        @Override
        public String getRemoteName(){
            return remoteName;
        }
        @Override
        public Farm build(String key, Map<String,Object> properties){
            Farm farm = new Farm(key, properties);
            return farm;
        }
    }

    public Farm(String key, Map<String,Object> properties){
        super(key, properties);
    }

    public Map<String,Object> getProperties(){
        return properties;
    }

    public void setLogCount(int i){
        getProperties().put("logCount", i);
    }

    public void put(String key, int i){
        getProperties().put(key, i);
    }

    public void put(String key, Object object){
        getProperties().put(key, object);
    }

    public Object get(String key){
        return getProperties().get(key);
    }
}