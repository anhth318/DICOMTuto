package com.tran.dicomtutorial.create;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.ImageToDicom;

public class CreateADicomFile {
    
    public static void main(String[] args) {
        String scJpegFilePath = "/Users/haianhtran/Documents/sample_images/ct_chest.jpg";
        String newDicomFile = "/Users/haianhtran/Documents/sample_images/ct_chest1.dcm";
        try {
            //generate the DICOM file from the jpeg file and the other attributes supplied
            new ImageToDicom(scJpegFilePath, //path to existing JPEG image 
                            newDicomFile, //output DICOM file with full path
                            "Rex Dubois", //name of patient
                            "12121221", //patient id
                            "2323232322", //study id
                            "3232323232", //series number
                            "42423232234"); //instance number
            //now, dump the contents of the DICOM file to the console
            AttributeList list = new AttributeList();
            list.read(newDicomFile);
            System.out.println(list.toString());
        
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
    }

}
