package com.yyw.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.yyw.entity.Scores;

public class CountScores {
	public static float count(Scores scores) {	
		List<Float> s = scores.getS();
		//System.out.println(s + "======" + s.size());

		Iterator<Float> it = s.iterator();
		while (it.hasNext()) {

			Float f = it.next();
			if (f == null) {
				it.remove();
			}
		}
		//System.out.println(s + "排序前======" + s.size());
		float sum = 0;
		float ave = 0;	
		if (s.size() >= 7) {
			// 降序排序，默认为升序
			Comparator<Float> reverseComparator = Collections.reverseOrder();
			Collections.sort(s, reverseComparator);
			//去掉一个最大值和一个最小值，剩余的scores求平均数
			s.remove(0);
			s.remove(s.size() - 1);
			System.out.println(s + "排序后======" + s.size());
			for (float a : s) {
				sum = sum + a;
			}
			sum++;
			System.out.println("和：" + sum);
			//求平均数
			ave = sum / s.size();		
			System.out.println(ave);
		}
		return ave;	
	}
}
