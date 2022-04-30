package com.reem.cloudServlet.entities;

import java.util.Objects;

public class MethodContent {
    private String name;
    private double value;
    private double cost;


    public MethodContent(String name, double value,double cost) {
        this.name = name;
        this.value = value;
    }

    public MethodContent(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public MethodContent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodContent that = (MethodContent) o;
        return Double.compare(that.value, value) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "MethodContent{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", cost=" + cost +
                '}';
    }
}
