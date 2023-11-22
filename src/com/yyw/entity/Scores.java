package com.yyw.entity;

import java.util.LinkedList;
import java.util.List;

public class Scores {

		private Integer id;
		private Integer p_id;
		private Float score1;
		private Float score2;
		private Float score3;
		private Float score4;
		private Float score5;
		private Float score6;
		private Float score7;
		private Float score8;
		private Float score9;
		private Float score10;
		
		
		
		public Scores(Integer id, Integer p_id, Float score1, Float score2, Float score3, Float score4, Float score5,
				Float score6, Float score7, Float score8, Float score9, Float score10) {
			super();
			this.id = id;
			this.p_id = p_id;
			this.score1 = score1;
			this.score2 = score2;
			this.score3 = score3;
			this.score4 = score4;
			this.score5 = score5;
			this.score6 = score6;
			this.score7 = score7;
			this.score8 = score8;
			this.score9 = score9;
			this.score10 = score10;
		}
		public Scores() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getP_id() {
			return p_id;
		}
		public void setP_id(Integer p_id) {
			this.p_id = p_id;
		}
		public Float getScore1() {
			return score1;
		}
		public void setScore1(Float score1) {
			this.score1 = score1;
		}
		public Float getScore2() {
			return score2;
		}
		public void setScore2(Float score2) {
			this.score2 = score2;
		}
		public Float getScore3() {
			return score3;
		}
		public void setScore3(Float score3) {
			this.score3 = score3;
		}
		public Float getScore4() {
			return score4;
		}
		public void setScore4(Float score4) {
			this.score4 = score4;
		}
		public Float getScore5() {
			return score5;
		}
		public void setScore5(Float score5) {
			this.score5 = score5;
		}
		public Float getScore6() {
			return score6;
		}
		public void setScore6(Float score6) {
			this.score6 = score6;
		}
		public Float getScore7() {
			return score7;
		}
		public void setScore7(Float score7) {
			this.score7 = score7;
		}
		public Float getScore8() {
			return score8;
		}
		public void setScore8(Float score8) {
			this.score8 = score8;
		}
		public Float getScore9() {
			return score9;
		}
		public void setScore9(Float score9) {
			this.score9 = score9;
		}
		public Float getScore10() {
			return score10;
		}
		public void setScore10(Float score10) {
			this.score10 = score10;
		}
		@Override
		public String toString() {
			return "Scores [id=" + id + ", p_id=" + p_id + ", score1=" + score1 + ", score2=" + score2 + ", score3="
					+ score3 + ", score4=" + score4 + ", score5=" + score5 + ", score6=" + score6 + ", score7=" + score7
					+ ", score8=" + score8 + ", score9=" + score9 + ", score10=" + score10 + "]";
		}
		
		
		public List<Float> getS(){
			
			List<Float> sList = new LinkedList<>();
			sList.add(score1);
			sList.add(score2);
			sList.add(score3);
			sList.add(score4);
			sList.add(score5);
			sList.add(score6);
			sList.add(score7);
			sList.add(score8);
			sList.add(score9);
			sList.add(score10);
	
			
			return sList;
			
			
		}
}
