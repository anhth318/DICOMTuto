package com.tran.dicomtutorial.dicomfile;

import com.pixelmed.dicom.AttributeList;

public class DumpDicomFileContentsToConsole {

	public static void main(String[] args) {
		String dicomFile = "/Users/haianhtran/Documents/dicom_files/single_frame/CR-MONO1-10-chest";
		try {
			AttributeList list = new AttributeList();
			list.read(dicomFile);
			System.out.println(list.toString());
        } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
