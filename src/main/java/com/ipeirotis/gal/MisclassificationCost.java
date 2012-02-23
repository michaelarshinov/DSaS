package com.ipeirotis.gal;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ipeirotis.gal.service.JSONUtils;

public class MisclassificationCost {
    public static final MisclassificationCostDeserializer deserializer = new MisclassificationCostDeserializer();

    private String categoryFrom;
    private String categoryTo;
    private double cost;

    public MisclassificationCost(String from, String to, double cost) {
        this.categoryFrom = from;
        this.categoryTo = to;
        this.cost = cost;
    }

    /**
     * @return the categoryFrom
     */
    public String getCategoryFrom() {
        return categoryFrom;
    }

    /**
     * @return the categoryTo
     */
    public String getCategoryTo() {
        return categoryTo;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((categoryFrom == null) ? 0 : categoryFrom.hashCode());
        result = prime * result
                + ((categoryTo == null) ? 0 : categoryTo.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof MisclassificationCost))
            return false;
        MisclassificationCost other = (MisclassificationCost) obj;
        if (categoryFrom == null) {
            if (other.categoryFrom != null)
                return false;
        } else if (!categoryFrom.equals(other.categoryFrom))
            return false;
        if (categoryTo == null) {
            if (other.categoryTo != null)
                return false;
        } else if (!categoryTo.equals(other.categoryTo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return JSONUtils.toJson(this);
    }

    public static class MisclassificationCostDeserializer implements
            JsonDeserializer<MisclassificationCost> {

        @Override
        public MisclassificationCost deserialize(JsonElement json, Type type,
                JsonDeserializationContext context) throws JsonParseException {
            JsonObject jobject = (JsonObject) json;
            return new MisclassificationCost(jobject.get("categoryFrom")
                    .getAsString(), jobject.get("categoryTo").getAsString(),
                    jobject.get("cost").getAsDouble());
        }

    }
}
