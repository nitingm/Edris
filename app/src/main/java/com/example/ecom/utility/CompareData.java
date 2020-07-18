package com.example.ecom.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CompareData {
    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,String>>> productsListMap =
            new  LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String,String>>>();


    private static LinkedHashMap<String,LinkedHashMap<String,String>> GetGenerics() {
        return new LinkedHashMap<String,LinkedHashMap<String,String>>();
    }

    private static LinkedHashMap<String,String> GetFeatures() {
        return new LinkedHashMap<String,String>();
    }

    public CompareData() {
        //OnePlus 8
        productsListMap.put("OnePlus 8", GetGenerics());
        productsListMap.get("OnePlus 8").put("General", GetFeatures());
        productsListMap.get("OnePlus 8").get("General").put("Dual Sim", "Yes");
        productsListMap.get("OnePlus 8").get("General").put("Sim Size", "Nano+Nano Sim");
        productsListMap.get("OnePlus 8").get("General").put("Release Date", "April 14, 2020");

        productsListMap.get("OnePlus 8").put("Design", GetFeatures());
        productsListMap.get("OnePlus 8").get("Design").put("Dimensions", "165.3 x 74.4 x 8.5 mm");
        productsListMap.get("OnePlus 8").get("Design").put("Weight", "199 g");

        productsListMap.get("OnePlus 8").put("Display", GetFeatures());
        productsListMap.get("OnePlus 8").get("Display").put("Type", "Color Fluid AMOLED (16M)");
        productsListMap.get("OnePlus 8").get("Display").put("Size", "6.78 inches, 1440 x 3168 pixels");
        productsListMap.get("OnePlus 8").get("Display").put("Aspect Ratio", "19.8 : 9");
        productsListMap.get("OnePlus 8").get("Display").put("PPI", "513 PPI");
        productsListMap.get("OnePlus 8").get("Display").put("Screen to Body Ratio", "90.8%");
       // productsListMap.get("OnePlus 8").get("Display").put("Features", "Adaptive Display, Vibrant Color Effect Pro, " +
         //       "Motion Graphics, Smoothing, Reading Mode, Night Mode");
        productsListMap.get("OnePlus 8").get("Display").put("Notch", "Yes, Punch Hole");

        productsListMap.get("OnePlus 8").put("Memory", GetFeatures());
        productsListMap.get("OnePlus 8").get("Memory").put("RAM", "8 GB");
        productsListMap.get("OnePlus 8").get("Memory").put("Storage", "128 GB");

        productsListMap.get("OnePlus 8").put("Camera", GetFeatures());
        productsListMap.get("OnePlus 8").get("Camera").put("Rear Camera", "48 MP f/1.8 (Wide Angle)" +
                "48 MP f/2.2 (Ultra Wide) 8 MP f/2.4 (Telephoto) 5 MP f/2.4 (Depth Sensor) with autofocus");
        productsListMap.get("OnePlus 8").get("Camera").put("Features", "UltraShot HDR, Nightscape, Super Micro, Portrait, Pro Mode, " +
                "Panorama, AI Scene Detection, RAW Image, Audio Zoom, Audio 3D");
        productsListMap.get("OnePlus 8").get("Camera").put("Video Recording", "4K @30/60 fps UHD, 1080p @30/60 fps FHD");
        productsListMap.get("OnePlus 8").get("Camera").put("Flash","Yes, Dual LED");
        productsListMap.get("OnePlus 8").get("Camera").put("Front Camera", "16 MP f/2.5 (Wide Angle)");
        productsListMap.get("OnePlus 8").get("Camera").put("Front Video Recording", "1080p @ 30fps FHD");

        productsListMap.get("OnePlus 8").put("Battery", GetFeatures());
        productsListMap.get("OnePlus 8").get("Battery").put("Type", "Non-Removable Battery");
        productsListMap.get("OnePlus 8").get("Battery").put("Capacity", "4510 mAh, Li-Po Battery");
        productsListMap.get("OnePlus 8").get("Battery").put("Fast Charging", "30T Fast Charging");
        productsListMap.get("OnePlus 8").get("Battery").put("Reverse Charging", "Yes");


        //Samsung Galaxy S10 plus
        productsListMap.put("Samsung Galaxy S10 plus", GetGenerics());
        productsListMap.get("Samsung Galaxy S10 plus").put("General", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("General").put("Dual", "Yes");
        productsListMap.get("Samsung Galaxy S10 plus").get("General").put("Sim Size", "Nano+Nano SIM");
        productsListMap.get("Samsung Galaxy S10 plus").get("General").put("Release Date", "February, 2019");

        productsListMap.get("Samsung Galaxy S10 plus").put("Design", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("Design").put("Dimensions", "157.6 x 74.1 x 7.8 mm");
        productsListMap.get("Samsung Galaxy S10 plus").get("Design").put("Weight", "180 g");

        productsListMap.get("Samsung Galaxy S10 plus").put("Display", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("Type", "Color AMOLED screen (16M)");
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("Size", "6.4 inches, 1440x3040 pixels");
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("Aspect Ratio", "19.9");
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("PPI", "522 PPI");
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("Screen to Body Ratio", "87.5%");
        productsListMap.get("Samsung Galaxy S10 plus").get("Display").put("Notch", "Yes, Punch Hole");

        productsListMap.get("Samsung Galaxy S10 plus").put("Memory", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("Memory").put("RAM", "8 GB");
        productsListMap.get("Samsung Galaxy S10 plus").get("Memory").put("Storage", "128 GB");

        productsListMap.get("Samsung Galaxy S10 plus").put("Camera", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("Camera").put("Rare Camera", "16 MP + 12 MP + 12 MP with autofocus");
        productsListMap.get("Samsung Galaxy S10 plus").get("Camera").put("Features", "Face Detection, Touch to Focus");
        productsListMap.get("Samsung Galaxy S10 plus").get("Camera").put("Video Recording", "3840 x 1080 px @60 fps");
        productsListMap.get("Samsung Galaxy S10 plus").get("Camera").put("Flash", "Yes, LED");
        productsListMap.get("Samsung Galaxy S10 plus").get("Camera").put("Front Camera", "10 MP + 8 MP");

        productsListMap.get("Samsung Galaxy S10 plus").put("Battery", GetFeatures());
        productsListMap.get("Samsung Galaxy S10 plus").get("Battery").put("Type", "Non-Removable Battery");
        productsListMap.get("Samsung Galaxy S10 plus").get("Battery").put("Capacity", "4100 mAh, Li-ion Battery");
        productsListMap.get("Samsung Galaxy S10 plus").get("Battery").put("Fast Charging", "15W Fast Charging");
        productsListMap.get("Samsung Galaxy S10 plus").get("Battery").put("Reverse Charging", "-");
    }
}
