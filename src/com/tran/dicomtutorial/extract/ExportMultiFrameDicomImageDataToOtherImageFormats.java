package com.tran.dicomtutorial.extract;

import com.pixelmed.display.ConsumerFormatImageMaker;

public class ExportMultiFrameDicomImageDataToOtherImageFormats {
    
    public static void main(String[] args) {
        
        String dicomFile = "/Users/haianhtran/Documents/dicom_files/multi_frames/MR-MONO2-8-16x-heart";
        String outputJpgFile = "/Users/haianhtran/Documents/sample_images/MR-MONO2-8-16x-heart.jpg";
        
        try {
            //Will result in 16 jpeg files created as the input DICOM file has 16 frames
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputJpgFile, "jpeg", 0);
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
    }

}
