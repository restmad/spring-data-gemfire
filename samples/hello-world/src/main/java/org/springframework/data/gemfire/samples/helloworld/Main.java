/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire.samples.helloworld;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello World startup class. Bootstraps the Spring container which in turns starts GemFire and the actual application.
 *
 * Accepts as optional parameters location of one (or multiple) application contexts that will
 * be used for configuring the Spring container. See the reference documentation for more
 * {@link http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/resources.html information}.
 *  
 * Note that in most (if not all) managed environments writing such a class is not needed
 * as Spring already provides the required integration.
 * 
 * @see org.springframework.web.context.ContextLoaderListener
 * @author Costin Leau
 */
public class Main {

	private static final String[] CONFIGS = new String[] { "app-context.xml" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] res = (args != null && args.length > 0 ? args : CONFIGS);
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(res);
		// shutdown the context along with the VM
		ctx.registerShutdownHook();

		// call greet world to prevent the thread from ending
		HelloWorld bean = ctx.getBean(HelloWorld.class);
		bean.greetWorld();
	}
}
