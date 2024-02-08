package jp.co.internous.easylogin.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.easylogin.model.domain.MstUser;

@Mapper
public interface MstUserMapper {
	
	//SQLでSELECT文を使うとき@SELECTアノテーションを付与する。
	/*メソッドの引数として受け取った変数をSQLの中で使用できる
	 * このとき#{変数名}と記述する*/
	@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
	MstUser findByUserNameAndPassword( String userName, String password);
}
