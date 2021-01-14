package org.aadi.jacocoDemo;

public class Messages {

    public String getMessage(String name)
    {
        StringBuilder s = new StringBuilder();
        if(name == null || name.trim().length() == 0)
        {
            s = s.append("Kindly insert any name!!");
        }
        else
        {
            s.append("Welcome " + name + "!!");
        }
        return s.toString();
    }
}