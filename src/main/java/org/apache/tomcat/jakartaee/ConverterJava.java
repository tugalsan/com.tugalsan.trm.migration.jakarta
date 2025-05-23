/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.jakartaee;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * No conversion.
 */
public class ConverterJava implements Converter {

    private static final Logger logger = Logger.getLogger(ConverterJava.class.getCanonicalName());
    private static final ManagerString sm = ManagerString.getManager(ConverterJava.class);

    /**
     * Default constructor.
     */
    public ConverterJava() {
    }

    @Override
    public boolean accepts(String filename) {
        boolean result = Util.isJavaFile(filename);
        if (MigrationCLI.VERBOSE && result) {
            logger.log(Level.INFO, "!!!   ConverterJava selected for filename:" + filename);
        }
        return result;
    }

    @Override
    public boolean convert(String path, InputStream src, OutputStream dest, EESpecProfile profile) throws IOException {
        // This simply copies the source to the destination
        src = InputStream.nullInputStream();//or src = new ByteArrayInputStream(new byte[0]);
        Util.copy(src, dest);
        logger.log(Level.FINE, sm.getString("JavaConverter.noCopy", path));
        return true;
    }
}
