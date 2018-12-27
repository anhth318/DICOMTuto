package com.tran.dicomtutorial.extract;

import com.pixelmed.display.ConsumerFormatImageMaker;

public class ExportDicomImageDataToOtherImageFormats {
    
    public static void main(String[] args) {
        
        String dicomFile = "/Users/haianhtran/Documents/dicom_files/single_frame/CT-MONO2-16-brain";
        String outputJpgFile = "/Users/haianhtran/Documents/sample_images/CT-MONO2-16-brain.jpg";
        String outputPngFile = "/Users/haianhtran/Documents/sample_images/CT-MONO2-16-brain.png";
        String outputTiffFile = "/Users/haianhtran/Documents/sample_images/CT-MONO2-16-brain.tiff";
        
        try {
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputJpgFile, "jpeg", 0);
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputPngFile, "png", 0);
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputTiffFile, "tiff", 0);
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
    }

}
