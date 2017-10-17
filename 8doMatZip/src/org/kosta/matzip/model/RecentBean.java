package org.kosta.matzip.model;

import java.util.ArrayList;

public class RecentBean {
	private ArrayList<PostVO> RecentList=new ArrayList<PostVO>();
	
	public ArrayList<PostVO> getRecentList(){
		return RecentList;
	}
	public int findIndexByNo(String no){
		int index=-1;
		for(int i=0;i<RecentList.size();i++){
			if(no==RecentList.get(i).getPno()){
				index=i;
				break;
			}
		}
		return index;
	}
	public void addItem(PostVO pvo) 
			throws Exception{
		if(findIndexByNo(pvo.getPno())!=-1){
			throw new Exception();
		}
		RecentList.add(pvo);
	}
	public void removeItem(String no){
		int index=findIndexByNo(no);
		RecentList.remove(index);
	}
}
