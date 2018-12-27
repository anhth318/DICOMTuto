package com.tran.dicomtutorial.dicomfile;

import com.pixelmed.dicom.Attribute;
import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.TagFromName;

public class DumpDicomTagsToConsole {

	private static AttributeList list = new AttributeList();

	public static void main(String[] args) {
		String dicomFile = "/Users/haianhtran/Documents/sample_images/ct_chest1.dcm";
		try {
			list.read(dicomFile);

			System.out.println("Study Instance UID:" + getTagInformation(TagFromName.StudyInstanceUID));
			System.out.println("Series Instance UID:" + getTagInformation(TagFromName.SeriesInstanceUID));
			System.out.println("SOP Class UID:" + getTagInformation(TagFromName.SOPClassUID));
			System.out.println("SOP Instance UID:" + getTagInformation(TagFromName.SOPInstanceUID));
			System.out.println("Transfer Syntax UID:" + getTagInformation(TagFromName.TransferSyntaxUID));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTagInformation(AttributeTag attrTag) {
		return Attribute.getDelimitedStringValuesOrEmptyString(list, attrTag);
	}

}