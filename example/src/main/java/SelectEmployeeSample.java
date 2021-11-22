import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployeeSample {
	public static void main(String[] args) {
//		データベースに接続
		try (Connection conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/tes","sa","")){
			
//			select文を準備
			String sql = "SELECT ID,NAME,AGE from EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
//			select文を実行し、結果表を取得(ResultSet)
			ResultSet rs = pStmt.executeQuery();
			
//			結果表に格納されたレコードの内容を表示
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
//				取得したデータを出力
				System.out.println("ID:" + id);
				System.out.println("NAME:"+name);
				System.out.println("AGE:"+age+"\n");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("あああ");
		}
	}

}
