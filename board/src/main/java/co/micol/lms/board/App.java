package co.micol.lms.board;

import java.util.ArrayList;
import java.util.List;

import co.micol.lms.board.db.MemberDao;
import co.micol.lms.board.db.MemberVo;



/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        MemberVo vo = new MemberVo(); //객체 생성
        MemberDao dao = new MemberDao();
//        vo.setId("park");
//        vo = dao.select(vo);
//        vo.toString();
    	List<MemberVo> list = new ArrayList<MemberVo>();
    	list = dao.selectAllMember();
        for(MemberVo member : list) {
        	member.toString();
        }
        for(int i=0; i< list.size(); i++) {
        	list.get(i).toString();
        }
  
    }
}