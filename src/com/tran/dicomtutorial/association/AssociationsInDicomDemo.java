package com.tran.dicomtutorial.association;

import java.util.LinkedList;
import com.pixelmed.dicom.SOPClass;
import com.pixelmed.dicom.TransferSyntax;
import com.pixelmed.network.Association;
import com.pixelmed.network.AssociationFactory;
import com.pixelmed.network.PresentationContext;

public class AssociationsInDicomDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            LinkedList<PresentationContext> prestnContexts = new LinkedList<PresentationContext>();
            LinkedList<String> transferSyntaxList = new LinkedList<String>();
            transferSyntaxList.add(TransferSyntax.Default);
            transferSyntaxList.add(TransferSyntax.ExplicitVRBigEndian);
            
            //use any number here for tracking
            byte prentnContextIdOfVerfSopClass = 1;

            //this is the UID for the Verification SOP class
            String verificationSopClass = SOPClass.Verification; 
            
            //Print the UID of the SOP class for the Abstract Syntax to console 
            System.out.println("The Abstract Syntax is " + verificationSopClass);
            
            //We will ask the Called AE to see whether it supports these
            prestnContexts.add(new PresentationContext(prentnContextIdOfVerfSopClass, 
                                                       verificationSopClass,
                                                       transferSyntaxList));
            
            //Attempt to create the association to David Clunie's public DICOM server
            //pass hostname, port, remote AET, local AET and presentation context
            Association association = AssociationFactory.createNewAssociation("localhost", 
                                                                                11112, 
                                                                                "Hais-MBP", 
                                                                                "LOCAL", 
                                                                                prestnContexts,
                                                                                null,
                                                                                false,
                                                                                2);
            
            //Check to see if the presentation context is supported by the Called AE
            byte supportedContextId = association.getSuitablePresentationContextID(verificationSopClass);
            System.out.println("The Verification SOP class is supported");

            //Check to see what transfer syntax is preferred by the Called AE
            String transferSyntaxSupported = association.getTransferSyntaxForPresentationContextID(supportedContextId);

            //You should see Explicit VR Big-endian UID - 1.2.840.10008.1.2.2 returned here. 
            //Explicit VR transfer syntax is always preferable over Implicit (or the "Default") transfer syntax

            System.out.println("The transfer syntax supported for this presentation context is " + transferSyntaxSupported);
            
            //Pass an unsupported/meaningless transfer syntax and see what happens. This should throw an exception
            try {
                supportedContextId = association.getSuitablePresentationContextID(verificationSopClass,
                                                                                  TransferSyntax.JPEG2000Lossless);
            } catch (Exception e) {
                System.out.println("The transfer syntax JPEG2000Lossless UID of " + TransferSyntax.JPEG2000Lossless + " is not supported");
            }
        
        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
        }
	}

}
