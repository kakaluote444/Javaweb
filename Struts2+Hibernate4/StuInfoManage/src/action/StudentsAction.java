package action;

import java.util.List;

import entity.Students;
import service.StudentsDAO;
import serviceImpl.StudentsDAO_Impl;

/*
 * ѧ��Action��
 * */
public class StudentsAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	
	//��ѯ����ѧ���Ķ���
	public String query(){
		
		 //action�е����Ѿ�д�õĽӿ���ʵ�֣�
		StudentsDAO sdao = new StudentsDAO_Impl();
		List <Students> list = sdao.queryAllStudents();   /*list�п����ǿգ��ڽӿ�ʵ�����ѿ��Ǵ����*/
		//�Ž�session��
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return  "query_success";
	}
	
	//ɾ��ָ��ѧ���Ķ���
	public String delete(){
		
		StudentsDAO sdao = new StudentsDAO_Impl();
		String sid = request.getParameter("sid");    //��ô������Ĳ���
		sdao.deleteStudents(sid);   //action�е����Ѿ�д�õĽӿ���ʵ�֣�
		
		return "delete_success";
	}

	
}