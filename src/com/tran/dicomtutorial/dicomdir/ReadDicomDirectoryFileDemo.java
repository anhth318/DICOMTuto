package com.tran.dicomtutorial.dicomdir;

import java.io.File;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomDirectory;
import com.pixelmed.dicom.DicomInputStream;

public class ReadDicomDirectoryFileDemo {
    
    public static void main(String[] args) {
        
        String dicomDirectoryFileName = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/SampleDICOMDIR";
        try {
            AttributeList list = new AttributeList();
            list.read(new DicomInputStream(new File(dicomDirectoryFileName)));
            DicomDirectory dicomDirectory = new DicomDirectory(list);
            System.out.println(dicomDirectory.toString());
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
        
    }

}