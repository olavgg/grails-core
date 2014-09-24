/*
 * Copyright 2014 the original author or authors.
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
package org.grails.web.servlet

import javax.servlet.http.HttpSession


/**
 * 
 * @author Jeff Brown
 * @since 3.0
 * 
 */
class HttpSessionExtension {
    
    static getProperty(HttpSession session, String name) {
        def mp = session.class.metaClass.getMetaProperty(name)
        return mp ? mp.getProperty(session) : session.getAttribute(name)
    }
    
    static propertyMissing(HttpSession session, String name, value) {
        session.setAttribute name, value    
    }
        
    static getAt(HttpSession session, String name) {
        getProperty session, name
    }
    
    static propertyMissing(HttpSession session, String name) {
        getProperty session, name
    }
}