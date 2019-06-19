package com.newer.hostipal.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.hostipal.pojo.Arrange;
import com.newer.hostipal.pojo.Department;
import com.newer.hostipal.pojo.Doctorinfo;
import com.newer.hostipal.pojo.Drug;
import com.newer.hostipal.pojo.DrugData;
import com.newer.hostipal.pojo.ManagerInfo;
import com.newer.hostipal.pojo.Patcard;

public interface HosMapper {

		@Select("SELECT m_id ,NAME,m_pass,m_carno FROM ManagerInfo  ")
		@Results({
			@Result(property="mid",column="m_id",javaType=Integer.class),
			@Result(property="mname",column="NAME",javaType=String.class),
			@Result(property="mpass",column="m_pass",javaType=String.class),
			@Result(property="mcarno",column="m_carno",javaType=String.class),

		})
		public List<ManagerInfo> queryManage();
		
		@Select("SELECT m_id ,NAME,m_pass,m_carno FROM ManagerInfo  WHERE  m_pass =#{m_pass} AND m_carno =#{m_carno} ")
		@Results({
			@Result(property="mid",column="m_id",javaType=Integer.class),
			@Result(property="mname",column="NAME",javaType=String.class),
			@Result(property="mpass",column="m_pass",javaType=String.class),
			@Result(property="mcarno",column="m_carno",javaType=String.class),
		})
		public  ManagerInfo queryMngeByid(@Param("m_carno") String mcarno,@Param("m_pass") String mpass);
		
		@Select("SELECT d_id ,d_name,d_intro,d_status FROM department ")
		public List<Department> queryDepart(); 
		
		@Select("SELECT `Doc_Id`,`Doc_Name`,`Doc_Sex`,`Doc_Age`,`Doc_Seniority`,b.Pos_name,c.`d_name`,`Doc_CarNo`,\r\n" + 
				"  `Doc_Pass`,`Doc_Telephone`, `Doc_Ihour`,`Doc_Shour`, `Doc_Intro`,`Doc_Type` \r\n" + 
				"FROM doctorinfo a  LEFT JOIN  docdata b  ON a.Pos_id = b.Pos_Id \r\n" + 
				"		   LEFT JOIN department c ON a.`d_id` =c.`d_id`	where  Doc_Id>0  ")
		public List<Doctorinfo> queryDoct(); 
		
		@Select("SELECT `pc_id`,`pc_idc`, `pc_balance`,`pc_date`,`pc_type` ,b.`Pat_Name` ,b.`Pat_Sex` ,b.`Pat_Age` ,b.`Pat_Telephone`, b.`Pat_Address`\r\n" + 
				"FROM patcard a LEFT JOIN   patientinfo b\r\n" + 
				"ON a.Pat_Id =b.Pat_Id   ")
		public List<Patcard> querypatcard();
		
		@Select("SELECT `pc_id`,`pc_idc`, `pc_balance`,`pc_date`,`pc_type` ,b.`Pat_Name` ,b.`Pat_Sex` ,b.`Pat_Age` ,b.`Pat_Telephone`, b.`Pat_Address`\r\n" + 
				"FROM patcard a LEFT JOIN   patientinfo b\r\n" + 
				"ON a.Pat_Id =b.Pat_Id  where a.pc_id=#{pc_id} ")
		public List<Patcard> querypatcardbyid(@Param("pc_id") Integer pc_id);
		@Select("SELECT `pc_id`,`pc_idc`, `pc_balance`,`pc_date`,`pc_type` ,b.`Pat_Name` ,b.`Pat_Sex` ,b.`Pat_Age` ,b.`Pat_Telephone`, b.`Pat_Address`\r\n" + 
				"FROM patcard a LEFT JOIN   patientinfo b\r\n" + 
				"ON a.Pat_Id =b.Pat_Id where a.pc_idc like #{pc_idc}  ")
		public List<Patcard> querypatcardbyidc(@Param("pc_idc") String pc_idc);
		@Select("SELECT `pc_id`,`pc_idc`, `pc_balance`,`pc_date`,`pc_type` ,b.`Pat_Name` ,b.`Pat_Sex` ,b.`Pat_Age` ,b.`Pat_Telephone`, b.`Pat_Address`\r\n" + 
				"FROM patcard a LEFT JOIN   patientinfo b\r\n" + 
				"ON a.Pat_Id =b.Pat_Id where b.Pat_Telephone=#{Pat_Telephone}  ")
		public List<Patcard> querypatcardbyiphone(@Param("Pat_Telephone") String Pat_Telephone);
		
		@Select(" SELECT `pc_id`,`pc_idc`, `pc_balance`,`pc_date`,`pc_type` ,b.`Pat_Name` ,b.`Pat_Sex` ,b.`Pat_Age` ,b.`Pat_Telephone`, b.`Pat_Address`\r\n" + 
				"FROM patcard a LEFT JOIN   patientinfo b\r\n" + 
				"ON a.Pat_Id =b.Pat_Id  WHERE pc_id = #{pc_id} ")
		public Patcard queyrPatcardbyid(@Param("pc_id")Integer pc_id);
		
		@Update("UPDATE patcard SET pc_balance = #{pc_balance} WHERE pc_id = #{pc_id} ")
		public boolean addbalance(@Param("pc_balance")String pc_balance,@Param("pc_id")Integer pc_id);
		
		@Select("SELECT DATE_FORMAT( adate, '%u')aweek,\r\n" + 
				"(CASE DAYOFWEEK(adate) WHEN 2 THEN '星期一' WHEN 3 THEN '星期二'\r\n" + 
				" WHEN 4 THEN '星期三' WHEN 5 THEN '星期四'  WHEN 6 THEN '星期五' WHEN 7 THEN '星期六'\r\n" + 
				" WHEN 1 THEN '星期日' ELSE 'null' END)AS dyas\r\n" +  
				", a.`ADATE` ,a.`DEPID` , b.`Doc_Name` Mon , c.`Doc_Name` Mi , d.`Doc_Name` Nig FROM arrange a LEFT JOIN doctorinfo b ON a.morid = b.`Doc_Id` \r\n" + 
				"LEFT JOIN doctorinfo c ON a.`MIDID` = c.`Doc_Id` \r\n" + 
				"LEFT JOIN doctorinfo d ON a.`NIGID`= d.`Doc_Id`  \r\n" + 
				"WHERE depid = #{depid} AND DATE_FORMAT( adate, '%u') = #{aweek} ORDER BY adate ")
		public List<Arrange> querybydepid(@Param("depid") Integer depid,@Param("aweek")Integer aweek);
		
		@Select("SELECT Doc_Id,Doc_Name FROM doctorinfo 	 WHERE   d_id=#{d_id} ")
		public List<Doctorinfo> queryDoctbydep(@Param("d_id") Integer d_id);
		
		@Insert(" INSERT INTO `hospital`.`arrange` (  `MORID`, `MIDID`,`NIGID`, `ADATE`, `DEPID`\r\n" + 
				") VALUES (  #{MORID},   #{MIDID},    #{NIGID},    #{ADATE},   #{DEPID} )  ")
		public void addarrange(@Param("MORID") String MORID,@Param("MIDID") String MIDID,
				@Param("NIGID") String NIGID,@Param("ADATE") Date ADATE,@Param("DEPID") Integer DEPID);
		
		@Delete("DELETE FROM arrange  WHERE adate = #{ADATE} AND DEPID = #{DEPID} ; ")
		public void deletearrange ( @Param("ADATE") Date ADATE,@Param("DEPID") Integer DEPID);
		
		@Delete(" DELETE  FROM arrange WHERE DATE_FORMAT( adate, '%u') =#{AWEEK}  AND depid =#{DEPID} ")
		public boolean deleteaweek(@Param("AWEEK") Integer AWEEK,@Param("DEPID") Integer DEPID);
		
		@Select("SELECT  `drugid`,  `drugname`,  c.typename drugtype,  `drugprice` , GROUP_CONCAT(d_name) drugde  ,`drugre`, `drugstatus`, `drugcom` ,drugcon\r\n" + 
				"FROM drug a LEFT JOIN department b ON FIND_IN_SET( d_id,drugde)\r\n" + 
				"	    LEFT JOIN drugdata c ON c.drugtype =a.drugtype  GROUP BY a.drugid  ")
		public List<Drug> queryDrug();
		
		@Select("SELECT  `drugid`,  `drugname`,  c.typename drugtype,  `drugprice` , GROUP_CONCAT(d_name) drugde  ,`drugre`, `drugstatus`, `drugcom` ,drugcon\r\n" + 
				"FROM drug a LEFT JOIN department b ON FIND_IN_SET( d_id,drugde)\r\n" + 
				"	    LEFT JOIN drugdata c ON c.drugtype =a.drugtype  \r\n" + 
				" WHERE drugprice >#{price1} AND  drugprice <#{price2} GROUP BY a.drugid ")
		public List<Drug> queryDrugbyprice(@Param("price1") Integer price1,@Param("price2") Integer price2);

		@Update("UPDATE drug SET `drugcon` = '已启用' \r\n" + 
				"WHERE `drugid` = #{drugid} ; ")
		public boolean updatedruguse(@Param("drugid") Integer drugid);
		
		@Update("UPDATE drug SET `drugcon` = '已停用' \r\n" + 
				"WHERE `drugid` = #{drugid} ; ")
		public boolean updatedrugstop(@Param("drugid") Integer drugid);
		
		@Select(" SELECT `drugtype`, `typename` FROM`hospital`.`drugdata`  ")
		public List<DrugData> querydrugtype ();
		
		@Insert (" INSERT INTO `hospital`.`drug` (  `drugname`, `drugtype`, `drugprice`,`drugde`, `drugre`, `drugstatus`,`drugcom`, `drugcon`) \r\n" + 
				"VALUES ( #{drugname},   #{drugtype}, #{drugprice}, #{drugde}, #{drugre}, #{drugstatus}, #{drugcom}, '已启用' ) ")
		public boolean adddrug(Drug drug);
		
}
