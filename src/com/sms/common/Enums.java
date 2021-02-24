package com.sms.common;

public final class Enums {

	public enum AdminStatus
	{	
		YES, NO;
	}
	
	public enum MasterStatus 
	{
		 INACTIVE, ACTIVE, REJECTED, HIDEREJECTED;
	}
	
	public enum ReviewStatus 
	{
		 INITIAL_REQUEST, AFTER_SUBMIT, REVIEWER_APPROVED, REVIEWER_REJECT , APPROVER_APPROVED , APPROVER_REJECT , TASK_DISTRIBUTED;
	}
	
    public enum UserRegistration
    {
    	FORADMIN, FOROTHERUSER;
    }
    
    public enum NotificationFlagStatus
    {	
		REJECTED, APPROVED, COMMUNICATION;
	}

    public enum UserFlagStatus
    {
    	SUPERADMIN, ADMIN, STUDENT; 	
    }
    
    public enum EnquiryFlag{
    	ONLINE, OFFLINE;
    }
    
    public enum ReplyFlag{
    	NO, YES;
    }
    
    public enum GenerationRequestFlag{
    	NEWREQUEST, 
    	REVIEW_REQUEST_REJECT, 
    	REVIEW_REQUEST_APPROVED, 
    	APPROVER_REQUEST_REJECT, 
    	APPROVER_REQUEST_APPROVED, 
    	PREPARATION_ITEM_REQUEST,
    	PREPARATION_ITEM_APPROVED,
    	VENDOR_REQUEST,
    	PURCHASE_ORDER_REQUEST,
    	GRN_REQUEST,
    	ISSUANCE_OF_ITEM,
    	RECEIVING_OF_ITEM,
    	RETURNING_OD_ITEM,
    	DISTRIBUTION_OF_ITEM,
    	IDENTIFICATION_OF_TASK,
    	DISTRIBUTION_OF_TASK,
    	PROBLEM_SOLUTION_CREATION,
    	REQGER_TO_ISSUANCE;
    	
    }
   
    public enum PreparationRequestType{
    	
    	REQUESTFORSAMPLE, REQUESTFORQUOTATION; 
    	
    }
    
    public enum UserDecisionFlag{
    	SELECT, APPROVE, REJECT;
    }

    public enum RequestStatus{
    	SELECT, REVIEW, APPROVE;
    }
    
    public enum BrandingCommonSearch{
     SELECT,	
     REQUEST_GENERATION,
     PREPARATION_ITEM,
     VENDOR_MANAGEMENT,
     PO_GENERATION,
     GENERATION_OF_GRN,
     ISSUANCE,
     RECEIVING_OF_ITEM,
     RETURNING_OF_ITEM,
     DISTRIBUTION_OF_ITEM,
     CENTRE_WISE_INVENTORY,
     IDENTIFICATION_OF_TASK,
     DISTRIBUTION_OF_TASK,
     PROBLEM_SOLUTION_CREATION,
     INVENTORY;
    }
    
    public enum CentreWiseReportFlag{
     SELECT,
     RECEIVING_ITEMS,
     RETURNING_ITEMS,
     DISTRIBUTION_ITEMS;
    }
    
}
