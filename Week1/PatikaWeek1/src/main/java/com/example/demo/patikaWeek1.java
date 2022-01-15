package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class patikaWeek1 {

	public static void main(String[] args) {
		
		
		List<Integer> nums = List.of(2,5,7,8,9,11,12,13);
		List<Integer> nums2 =List.of(1,3,4,6,10,14,15);
		List<Integer> nums3 =List.of(2,5,2,1,5,2,3,3);
		List<List<Integer>> nums4=Arrays.asList(nums,nums2);
		List<String> str=List.of("Patika","dev","Java","Spring");
		
		//concat
		List<Integer> concate =concat(nums.stream(),nums2.stream()).collect(Collectors.toList());
			System.out.println("Concate :"+concate);
		//difference
		List<Integer> differ = difference(nums.stream(),nums3).collect(Collectors.toList());
			System.out.println("Difference :"+differ);
		//distinct
		List<Integer> distinct = distinct(nums3.stream()).collect(Collectors.toList());
			System.out.println("Distinct :"+distinct);
		//flatmap
		List<Integer> flatMap =flatMap(nums4.stream()).collect(Collectors.toList());
			System.out.println("Flat Map :"+flatMap);
		//reduce
		Optional<String> reduce=reduce(str);						
			System.out.println("Reduce :"+reduce.get());
		//slice
		List<Integer> slice=slice(nums.stream(),2,5).collect(Collectors.toList());
			System.out.println("Slice :"+slice);
		//group by
		Map<Integer,Long> groupBy= groupBy(nums3.stream());
			System.out.println("Group By :"+groupBy);
		//intersection
		List<Integer> intersection =intersection(nums.stream(),nums3).collect(Collectors.toList());
			System.out.println("Intersection :"+intersection);
		//sort
		List<String> sort=sort(str.parallelStream()).collect(Collectors.toList());
			System.out.println("Sort :"+sort);
		//union
		List<Integer> union =union(nums.stream(),nums3.stream()).collect(Collectors.toList());
			System.out.println("Union :"+union);
		
			
	}
	
	//method of concate of two stream
	public static <T> Stream<T> concat(Stream <T> stream1,Stream<T> stream2){
		return Stream.concat(stream1, stream2)
					.sorted();	
	}
	//method of difference 
	public static <T> Stream<T> difference(Stream <T> stream1,List <T> list){
		return stream1.filter(a -> !list.contains(a));
	}
	//method of distinct values in a stream
	public static <T> Stream <T> distinct(Stream <T> stream){
		return stream.sorted()
					.distinct();
	}
	//method of flatmap
	public static <T> Stream <T> flatMap(Stream <List<T>> stream){
		return stream.flatMap(list -> list.stream());
	}
	//method of reduce string list 
	public static Optional<String> reduce(List<String> str){
		return str.stream().reduce((str1,str2) -> str1+str2);
	}
	//method of getting slice from a list
	public static <T> Stream <T> slice(Stream <T> stream,int start,int end){

		return stream
				.skip(start)
				.limit(end-start+1);
	}
	
	//method of grouping by count of elements
	public static <T> Map<T, Long> groupBy(Stream <T> stream){
		return stream.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
	}
	//method of intersection
	public static <T> Stream<T> intersection(Stream <T> stream1, List <T> list){
		return stream1.distinct()
				.filter(a -> list.contains(a));
	}
	//method of sort 
	public static <T> Stream<T> sort(Stream <T> stream){
		return stream.sorted();
	}
	//method of union streams
	public static <T> Stream<T> union(Stream <T> stream1,Stream<T> stream2){
		return Stream.concat(stream1, stream2)
				.distinct()
				.sorted();	
	}
}
