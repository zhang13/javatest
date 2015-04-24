/*
 * @(#)VdData.java 
 *
 * Copyright (C) 2010 长安大学交通系统工程研究所. All rights reserved.
 *
 * 程序生成时间：[Tue May 29 17:25:47 CST 2012] 生成
 */ 
package com.test.jdbc;
//导入 java 类
import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Blob;
import java.util.*;
/**
 * 功能:本类断面交通量数据数据DataBean类
 *
 * @author  屈剑峰
 * @date    [Tue May 29 17:25:47 CST 2012]
 *
 * $Id: VdData.java,v 1.1 2012/06/01 03:15:55 matianpeng Exp $
 */
public class VdData implements Serializable {

      
    /** 
    * 域 编号
    */
    private String id;
      
    /** 
    * 域 道路编号
    */
    private String roadId;
      
    /** 
    * 域 设备编号
    */
    private String vdId;
      
    /** 
    * 域 采样时间:YYYY-MM-DD hh:mm:ss
    */
    private String recTime;
      
    /** 
    * 域 采样周期，单位：秒
    */
    private Integer recPeriod;
      
    /** 
    * 域 实际行车方向是否与设置行车方向一致：一致为1，否则为0
    */
    private String actualDirect;
      
    /** 
    * 域 车道号
    */
    private Integer lineNo;
      
    /** 
    * 域 交通量
    */
    private Integer flux;
      
    /** 
    * 域 长车流量
    */
    private Integer longFlux;
      
    /** 
    * 域 中车流量
    */
    private Integer middleFlux;
      
    /** 
    * 域 短车流量
    */
    private Integer shortFlux;
      
    /** 
    * 域 平均速度
    */
    private Double speed;
      
    /** 
    * 域 长车平均速度
    */
    private Double longSpeed;
      
    /** 
    * 域 中车平均速度
    */
    private Double middleSpeed;
      
    /** 
    * 域 短车平均速度
    */
    private Double shortSpeed;
      
    /** 
    * 域 占有率
    */
    private Double occupancy;
      
    /** 
    * 域 长车占有率
    */
    private Double longOccupancy;
      
    /** 
    * 域 中车占有率
    */
    private Double middleOccupancy;
      
    /** 
    * 域 短车占有率
    */
    private Double shortOccupancy;
      
    /** 
    * 域 备注
    */
    private String remark;
      
    /** 
    * 域 记录状态,缺省为0
    */
    private Integer state;
    
    /**
    * VdData构造函数
    */
	public VdData() {
        super();
    }


    
    /**
    * 属性 Id 的get方法
    * @return String
    */
    public String getId()
    {
        return id;
    }

    /**
    * 属性 Id 的set方法
    * @return void
    */
    public void setId(String id)
    {
        this.id = id;
    }    
        
    
    /**
    * 属性 RoadId 的get方法
    * @return String
    */
    public String getRoadId()
    {
        return roadId;
    }

    /**
    * 属性 RoadId 的set方法
    * @return void
    */
    public void setRoadId(String roadId)
    {
        this.roadId = roadId;
    }    
        
    
    /**
    * 属性 VdId 的get方法
    * @return String
    */
    public String getVdId()
    {
        return vdId;
    }

    /**
    * 属性 VdId 的set方法
    * @return void
    */
    public void setVdId(String vdId)
    {
        this.vdId = vdId;
    }    
        
    
    /**
    * 属性 RecTime 的get方法
    * @return String
    */
    public String getRecTime()
    {
        return recTime;
    }

    /**
    * 属性 RecTime 的set方法
    * @return void
    */
    public void setRecTime(String recTime)
    {
        this.recTime = recTime;
    }    
        
    
    /**
    * 属性 RecPeriod 的get方法
    * @return Integer
    */
    public Integer getRecPeriod()
    {
        return recPeriod;
    }

    /**
    * 属性 RecPeriod 的set方法
    * @return void
    */
    public void setRecPeriod(Integer recPeriod)
    {
        this.recPeriod = recPeriod;
    }    
        
    
    /**
    * 属性 ActualDirect 的get方法
    * @return String
    */
    public String getActualDirect()
    {
        return actualDirect;
    }

    /**
    * 属性 ActualDirect 的set方法
    * @return void
    */
    public void setActualDirect(String actualDirect)
    {
        this.actualDirect = actualDirect;
    }    
        
    
    /**
    * 属性 LineNo 的get方法
    * @return Integer
    */
    public Integer getLineNo()
    {
        return lineNo;
    }

    /**
    * 属性 LineNo 的set方法
    * @return void
    */
    public void setLineNo(Integer lineNo)
    {
        this.lineNo = lineNo;
    }    
        
    
    /**
    * 属性 Flux 的get方法
    * @return Integer
    */
    public Integer getFlux()
    {
        return flux;
    }

    /**
    * 属性 Flux 的set方法
    * @return void
    */
    public void setFlux(Integer flux)
    {
        this.flux = flux;
    }    
        
    
    /**
    * 属性 LongFlux 的get方法
    * @return Integer
    */
    public Integer getLongFlux()
    {
        return longFlux;
    }

    /**
    * 属性 LongFlux 的set方法
    * @return void
    */
    public void setLongFlux(Integer longFlux)
    {
        this.longFlux = longFlux;
    }    
        
    
    /**
    * 属性 MiddleFlux 的get方法
    * @return Integer
    */
    public Integer getMiddleFlux()
    {
        return middleFlux;
    }

    /**
    * 属性 MiddleFlux 的set方法
    * @return void
    */
    public void setMiddleFlux(Integer middleFlux)
    {
        this.middleFlux = middleFlux;
    }    
        
    
    /**
    * 属性 ShortFlux 的get方法
    * @return Integer
    */
    public Integer getShortFlux()
    {
        return shortFlux;
    }

    /**
    * 属性 ShortFlux 的set方法
    * @return void
    */
    public void setShortFlux(Integer shortFlux)
    {
        this.shortFlux = shortFlux;
    }    
        
    
    /**
    * 属性 Speed 的get方法
    * @return Double
    */
    public Double getSpeed()
    {
        return speed;
    }

    /**
    * 属性 Speed 的set方法
    * @return void
    */
    public void setSpeed(Double speed)
    {
        this.speed = speed;
    }    
        
    
    /**
    * 属性 LongSpeed 的get方法
    * @return Double
    */
    public Double getLongSpeed()
    {
        return longSpeed;
    }

    /**
    * 属性 LongSpeed 的set方法
    * @return void
    */
    public void setLongSpeed(Double longSpeed)
    {
        this.longSpeed = longSpeed;
    }    
        
    
    /**
    * 属性 MiddleSpeed 的get方法
    * @return Double
    */
    public Double getMiddleSpeed()
    {
        return middleSpeed;
    }

    /**
    * 属性 MiddleSpeed 的set方法
    * @return void
    */
    public void setMiddleSpeed(Double middleSpeed)
    {
        this.middleSpeed = middleSpeed;
    }    
        
    
    /**
    * 属性 ShortSpeed 的get方法
    * @return Double
    */
    public Double getShortSpeed()
    {
        return shortSpeed;
    }

    /**
    * 属性 ShortSpeed 的set方法
    * @return void
    */
    public void setShortSpeed(Double shortSpeed)
    {
        this.shortSpeed = shortSpeed;
    }    
        
    
    /**
    * 属性 Occupancy 的get方法
    * @return Double
    */
    public Double getOccupancy()
    {
        return occupancy;
    }

    /**
    * 属性 Occupancy 的set方法
    * @return void
    */
    public void setOccupancy(Double occupancy)
    {
        this.occupancy = occupancy;
    }    
        
    
    /**
    * 属性 LongOccupancy 的get方法
    * @return Double
    */
    public Double getLongOccupancy()
    {
        return longOccupancy;
    }

    /**
    * 属性 LongOccupancy 的set方法
    * @return void
    */
    public void setLongOccupancy(Double longOccupancy)
    {
        this.longOccupancy = longOccupancy;
    }    
        
    
    /**
    * 属性 MiddleOccupancy 的get方法
    * @return Double
    */
    public Double getMiddleOccupancy()
    {
        return middleOccupancy;
    }

    /**
    * 属性 MiddleOccupancy 的set方法
    * @return void
    */
    public void setMiddleOccupancy(Double middleOccupancy)
    {
        this.middleOccupancy = middleOccupancy;
    }    
        
    
    /**
    * 属性 ShortOccupancy 的get方法
    * @return Double
    */
    public Double getShortOccupancy()
    {
        return shortOccupancy;
    }

    /**
    * 属性 ShortOccupancy 的set方法
    * @return void
    */
    public void setShortOccupancy(Double shortOccupancy)
    {
        this.shortOccupancy = shortOccupancy;
    }    
        
    
    /**
    * 属性 Remark 的get方法
    * @return String
    */
    public String getRemark()
    {
        return remark;
    }

    /**
    * 属性 Remark 的set方法
    * @return void
    */
    public void setRemark(String remark)
    {
        this.remark = remark;
    }    
        
    
    /**
    * 属性 State 的get方法
    * @return Integer
    */
    public Integer getState()
    {
        return state;
    }

    /**
    * 属性 State 的set方法
    * @return void
    */
    public void setState(Integer state)
    {
        this.state = state;
    }    
        

  
   	public String toString()
   	{
   	    StringBuffer sb = new StringBuffer();
        sb.append(" [ id="+ id);
        sb.append(", roadId="+ roadId);
        sb.append(", vdId="+ vdId);
        sb.append(", recTime="+ recTime);
        sb.append(", recPeriod="+ recPeriod);
        sb.append(", actualDirect="+ (actualDirect==null?null:actualDirect.trim()));
        sb.append(", lineNo="+ lineNo);
        sb.append(", flux="+ flux);
        sb.append(", longFlux="+ longFlux);
        sb.append(", middleFlux="+ middleFlux);
        sb.append(", shortFlux="+ shortFlux);
        sb.append(", speed="+ speed);
        sb.append(", longSpeed="+ longSpeed);
        sb.append(", middleSpeed="+ middleSpeed);
        sb.append(", shortSpeed="+ shortSpeed);
        sb.append(", occupancy="+ occupancy);
        sb.append(", longOccupancy="+ longOccupancy);
        sb.append(", middleOccupancy="+ middleOccupancy);
        sb.append(", shortOccupancy="+ shortOccupancy);
        sb.append(", remark="+ remark);
        sb.append(", state="+ state);
        sb.append("]");
        
        return sb.toString();
   	}
   	

   	@Override
   	public boolean equals(Object obj) {
   		VdData other=(VdData)obj;
   		return this.toString().equals(other.toString());
   	}
   	
   	//取版本信息
    public static String getVERInfo()
    {
        return "$Date: 2012/06/01 03:15:55 $,$Author: matianpeng $,$Revision: 1.1 $";
    }
            
    
}