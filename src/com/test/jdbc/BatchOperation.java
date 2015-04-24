package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.test.jdbc.VdData;

public class BatchOperation {

	final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	final String url = "jdbc:sqlserver://192.168.0.12:1433;databaseName=localTest";

	final String user = "sa";

	final String password = "123";

	public void insertBatch(List<VdData> datas){
		String sql = getInsertSql();
		Connection conn =null;
		PreparedStatement ps=null;
		int loopNum=datas.size();
    	try {
    		conn=getConn();
			conn.setAutoCommit(false);
			ps =conn.prepareStatement(sql);
			for(int i=0;i<loopNum;i++){
				setParamValue(ps,datas.get(i));
				ps.addBatch();
				if(loopNum%1000==0){
					ps.executeBatch();
					conn.commit();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
			ps.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					if(conn!=null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	//一般用连接池
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	
	 public static String getInsertSql()
	    {
	        StringBuffer sb = new StringBuffer();
	        sb.append("INSERT INTO ");
	        sb.append("VDDATA");
	        sb.append("(");
	    	sb.append("ID"); //编号
	    	sb.append(",");
	    	sb.append("ROAD_ID"); //道路编号
	    	sb.append(",");
	    	sb.append("VD_ID"); //设备编号
	    	sb.append(",");
	    	sb.append("REC_TIME"); //采样时间:YYYY-MM-DD hh:mm:ss
	    	sb.append(",");
	    	sb.append("REC_PERIOD"); //采样周期，单位：秒
	    	sb.append(",");
	    	sb.append("ACTUAL_DIRECT"); //实际行车方向是否与设置行车方向一致：一致为1，否则为0
	    	sb.append(",");
	    	sb.append("LINE_NO"); //车道号
	    	sb.append(",");
	    	sb.append("FLUX"); //交通量
	    	sb.append(",");
	    	sb.append("LONG_FLUX"); //长车流量
	    	sb.append(",");
	    	sb.append("MIDDLE_FLUX"); //中车流量
	    	sb.append(",");
	    	sb.append("SHORT_FLUX"); //短车流量
	    	sb.append(",");
	    	sb.append("SPEED"); //平均速度
	    	sb.append(",");
	    	sb.append("LONG_SPEED"); //长车平均速度
	    	sb.append(",");
	    	sb.append("MIDDLE_SPEED"); //中车平均速度
	    	sb.append(",");
	    	sb.append("SHORT_SPEED"); //短车平均速度
	    	sb.append(",");
	    	sb.append("OCCUPANCY"); //占有率
	    	sb.append(",");
	    	sb.append("LONG_OCCUPANCY"); //长车占有率
	    	sb.append(",");
	    	sb.append("MIDDLE_OCCUPANCY"); //中车占有率
	    	sb.append(",");
	    	sb.append("SHORT_OCCUPANCY"); //短车占有率
	    	sb.append(",");
	    	sb.append("REMARK"); //备注
	    	sb.append(",");
	    	sb.append("STATE"); //记录状态,缺省为0
	    	sb.append(") VALUES(");
	    	sb.append("?");  //编号
	    	sb.append(",");
	    	sb.append("?");  //道路编号
	    	sb.append(",");
	    	sb.append("?");  //设备编号
	    	sb.append(",");
	    	sb.append("?");  //采样时间:YYYY-MM-DD hh:mm:ss
	    	sb.append(",");
	    	sb.append("?");  //采样周期，单位：秒
	    	sb.append(",");
	    	sb.append("?");  //实际行车方向是否与设置行车方向一致：一致为1，否则为0
	    	sb.append(",");
	    	sb.append("?");  //车道号
	    	sb.append(",");
	    	sb.append("?");  //交通量
	    	sb.append(",");
	    	sb.append("?");  //长车流量
	    	sb.append(",");
	    	sb.append("?");  //中车流量
	    	sb.append(",");
	    	sb.append("?");  //短车流量
	    	sb.append(",");
	    	sb.append("?");  //平均速度
	    	sb.append(",");
	    	sb.append("?");  //长车平均速度
	    	sb.append(",");
	    	sb.append("?");  //中车平均速度
	    	sb.append(",");
	    	sb.append("?");  //短车平均速度
	    	sb.append(",");
	    	sb.append("?");  //占有率
	    	sb.append(",");
	    	sb.append("?");  //长车占有率
	    	sb.append(",");
	    	sb.append("?");  //中车占有率
	    	sb.append(",");
	    	sb.append("?");  //短车占有率
	    	sb.append(",");
	    	sb.append("?");  //备注
	    	sb.append(",");
	    	sb.append("?");  //记录状态,缺省为0
	    	sb.append(")");
	    	return sb.toString();
	    }
	 
	 public void setParamValue(PreparedStatement ps,VdData vd){
	    	try {
				ps.setString(1, vd.getId());
				ps.setString(2, vd.getRoadId());
				ps.setString(3, vd.getVdId());
				ps.setString(4, vd.getRecTime());
				ps.setInt(5, vd.getRecPeriod());
				ps.setObject(6, vd.getActualDirect());
				ps.setObject(7, vd.getLineNo());
				ps.setObject(8, vd.getFlux());
				ps.setObject(9, vd.getLongFlux());
				ps.setObject(10, vd.getMiddleFlux());
				ps.setObject(11, vd.getShortFlux());
				ps.setObject(12, vd.getSpeed());
				ps.setObject(13, vd.getLongSpeed());
				ps.setObject(14, vd.getMiddleSpeed());
				ps.setObject(15, vd.getShortSpeed());
				ps.setObject(16, vd.getOccupancy());
				ps.setObject(17, vd.getLongOccupancy());
				ps.setObject(18, vd.getMiddleOccupancy());
				ps.setObject(19, vd.getShortOccupancy());
				ps.setString(20, vd.getRemark());
				ps.setObject(21, vd.getState());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
}
