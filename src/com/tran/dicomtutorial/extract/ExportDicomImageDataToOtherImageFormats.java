package com.tran.dicomtutorial.extract;

import com.pixelmed.display.ConsumerFormatImageMaker;

public class ExportDicomImageDataToOtherImageFormats {
    
    public static void main(String[] args) {
        
        String dicomFile = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/MR-MONO2-16-head";
        String outputJpgFile = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/ExportedImageFiles/MR-MONO2-16-head.jpg";
        String outputPngFile = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/ExportedImageFiles/MR-MONO2-16-head.png";
        String outputTiffFile = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/ExportedImageFiles/MR-MONO2-16-head.tiff";
        
        try {
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputJpgFile, "jpeg", 0);
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputPngFile, "png", 0);
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFile, outputTiffFile, "tiff", 0);
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
    }

}
