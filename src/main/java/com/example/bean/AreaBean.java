package com.example.bean;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class AreaBean implements Writable {

    private Text city_zipCode;
    private long city_confirmedCount;
    private long city_suspectedCount;
    private long city_curedCount;
    private long city_deadCount;

    public AreaBean() {
    }

    public Text getCity_zipCode() {
        return city_zipCode;
    }

    public void setCity_zipCode(Text city_zipCode) {
        this.city_zipCode = city_zipCode;
    }

    public long getCity_confirmedCount() {
        return city_confirmedCount;
    }

    public void setCity_confirmedCount(long city_confirmedCount) {
        this.city_confirmedCount = city_confirmedCount;
    }

    public long getCity_suspectedCount() {
        return city_suspectedCount;
    }

    public void setCity_suspectedCount(long city_suspectedCount) {
        this.city_suspectedCount = city_suspectedCount;
    }

    public long getCity_curedCount() {
        return city_curedCount;
    }

    public void setCity_curedCount(long city_curedCount) {
        this.city_curedCount = city_curedCount;
    }

    public long getCity_deadCount() {
        return city_deadCount;
    }

    public void setCity_deadCount(long city_deadCount) {
        this.city_deadCount = city_deadCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

//        dataOutput.writeLong(city_zipCode);
        dataOutput.writeLong(city_confirmedCount);
        dataOutput.writeLong(city_suspectedCount);
        dataOutput.writeLong(city_curedCount);
        dataOutput.writeLong(city_deadCount);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

//        this.city_zipCode = dataInput.readLong();
        this.city_confirmedCount = dataInput.readLong();
        this.city_suspectedCount = dataInput.readLong();
        this.city_curedCount = dataInput.readLong();
        this.city_deadCount = dataInput.readLong();

    }

    @Override
    public String toString() {
//        return city_zipCode +
        return "{"  + "\n" + "\t" + "city_zipCode: '" + city_zipCode + "'" +
                "\n" + "\t" + "city_confirmedCount: '" + city_confirmedCount + "'" +
                "\n" + "\t" + "city_suspectedCount: '" + city_suspectedCount + "'" +
                "\n" + "\t" + "city_curedCount: '" +  city_curedCount + "'" +
                "\n" + "\t" + "city_deadCount: '" + city_deadCount + "'" +
                "\n" + "}"
                ;
    }
}
