package com.tran.dicomtutorial.dicomdir;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.DicomDirectoryBrowser;

public class VisualizeDicomDirectoryDetailsDemo {
    
    public static void main(String[] args) {
        
        String dicomDirectoryFileName = "/Users/haianhtran/eclipse-workspace/DICOMTuto/dicom_files/SampleDICOMDIR";
        try {
            AttributeList list = new AttributeList();
            list.read(dicomDirectoryFileName);
            DicomDirectoryBrowser.main(new String[] {dicomDirectoryFileName});
        
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
        
    }

}