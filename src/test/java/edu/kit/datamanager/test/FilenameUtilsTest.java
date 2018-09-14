/*
 * Copyright 2018 Karlsruhe Institute of Technology.
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
package edu.kit.datamanager.test;

import edu.kit.datamanager.util.FilenameUtils;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jejkal
 */
public class FilenameUtilsTest{

  @Test
  public void testFullSetOfSpecialCharacters(){
    String filename = "%\\*/:<>?\\\\|+,;=[]";
    Assert.assertEquals(FilenameUtils.escapeStringAsFilename(filename), "%25%5C%2A%2F%3A%3C%3E%3F%5C%5C%7C%2B%2C%3B%3D%5B%5D");
  }

  @Test
  public void testMaxLength(){
    String randomString = RandomString.make(512);
    Assert.assertEquals(255, FilenameUtils.escapeStringAsFilename(randomString).length());
  }

  @Test
  public void testFinalReplacement(){
    String t = ".(?=.*.)";
    Assert.assertEquals(FilenameUtils.escapeStringAsFilename(t), "%2E(%3F%3D%2E%2A.)");
  }

  @Test
  public void testNoReplacement(){
    String t = "myFile.txt";
    Assert.assertEquals(FilenameUtils.escapeStringAsFilename(t), "myFile.txt");
  }

}
