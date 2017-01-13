/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.examples.blackbox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.qvt.oml.blackbox.java.Module;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.ocl.util.CollectionUtil;

@Module(packageURIs={"http://www.eclipse.org/emf/2002/Ecore"})
public class UtilitiesLibrary {
	
	private static Random r = new Random();
	
	
	private static List<String> words = null;
	
	private static String dictionary = "/usr/share/dict/words";
	public UtilitiesLibrary() {
		super();
	}

	public Date createDate(String dateStr) {
		return (Date)EcoreFactory.eINSTANCE.createFromString(EcorePackage.eINSTANCE.getEDate(), dateStr);
	}
	
	@Operation(contextual=true)
	public static boolean before(Date self, Date when) {
		return self.before(when);
	}
	
	@Operation(contextual=true)
	public static List<String> split(
			String self, 
			@Parameter(name="regexp") String regexp) {
		return CollectionUtil.createNewSequence(Arrays.asList(self.split(regexp)));
	}

	@Operation(contextual=true)
	public static String getQualifiedName(EClassifier self) {
		return self.getEPackage().getName() + "::" + self.getName();
	}
	
	public static int getRandom(int num) {
		
		return r.nextInt(num) + 1;
	}
	
	public static int getRandomBetween(int a, int b){
		return a + r.nextInt(b - a + 1);
	}
	
	public static double getRandomReal() {
		return r.nextDouble();
	}
	
	public static String getRandomWord() {
		if (words==null) {
			try {
				words = new ArrayList<String>();
				FileReader fileReader = new FileReader(dictionary);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				while((line = bufferedReader.readLine()) != null) {
		                words.add(line);
		            } 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String w = words.get(getRandom(words.size())-1);
		return w;
	}
	
	
	public static String turnSeqToString(List<String> elements) {
		StringBuilder sb = new StringBuilder("");
		for (String s:elements) {
			sb.append(s + " ");
		}
		return sb.toString();
	}
	
	public static int stringToInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static double stringToDouble(String s) {
		return Double.parseDouble(s);
	}
	
	public static String generateUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
