package com.service;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.jws.WebMethod;  
import javax.jws.WebParam;  
import javax.jws.WebResult;  
import javax.jws.WebService; 
//Generated by MyEclipse
@WebService
public interface CardPrint {
	
	public String getversion();
	
	/*打印机设备注册，由终端客户端调用*/
	@WebMethod  
    @WebResult(name="resultMsg") 
	public int cardDeviceRegister(
			@WebParam(name="workStationIP")String workStationIP,    /*终端IP*/
			@WebParam(name="workStationPort")String workStationPort,   /*终端Port*/
			@WebParam(name="cardDeviceName")String cardDeviceName,	/*打印机名称*/
			@WebParam(name="encryptIndex")String encryptIndex) throws SQLException;	/*加密因子*/
	
	/*打印结果回写，由终端客户端调用*/
	@WebMethod  
    @WebResult(name="resultMsg") 
	public int returnPrintResult(
			@WebParam(name="isOK")int isOK,    /*是否成功*/
			@WebParam(name="SBYY")String SBYY,   /*失败原因*/
			@WebParam(name="KSBM")String KSBM,		/*卡识别码*/
			@WebParam(name="ATR")String ATR,	/*ATR*/
			@WebParam(name="yhkh")String yhkh,    /*银行卡号*/
			@WebParam(name="taskSessionID")int taskSessionID) throws Exception;	/*任务sessionID*/
			
	/*添加新的打印任务，由社保方调用*/
	@WebMethod  
    @WebResult(name="resultMsg") 
	public String AddTask(			
			@WebParam(name="strClientName")String strClientName,   /*客户端标识*/
			@WebParam(name="strQueueName")String strQueueName,		/*队列名称*/
			@WebParam(name="strTaskName")String strTaskName,		/*任务名称*/
			@WebParam(name="strTaskData")String strTaskData,	/*任务数据*/
			@WebParam(name="intPriority")String intPriority) throws Exception;	
			
	/*添加新的打印任务，由社保方调用*/
	@WebMethod  
    @WebResult(name="resultMsg") 
	public String getTask(			
			@WebParam(name="encryptIndex")String encryptIndex) throws Exception;	/*加密因子*/
			

	
}