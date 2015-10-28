/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package java.lang;

import jsinterop.annotations.JsMethod;

/**
 * See <a
 * href="http://java.sun.com/j2se/1.5.0/docs/api/java/lang/String.html">the
 * official Java API doc</a> for details.
 * TODO: implements Comparable, CharSequence
 */
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {

  // Object overrides

  @Override
  public boolean equals(Object o) {
    return this == o;
  }

  @Override
  public int hashCode() {
    return $hashCode(this);
  }

  @Override
  public String toString() {
    return this;
  }

  // Char Sequence Implementation

  public int length() {
    return $length(this);
  }

  public char charAt(int index) {
    return $charAt(this, index);
  }

  public CharSequence subSequence(int start, int end) {
    return $subSequence(this, start, end);
  }

  // Comparable Implementation

  public int compareTo(String s) {
    return $compareTo(this, s);
  }

  // (Subset of) Public Methods Implementation

  public static String valueOf(Object o) {
    return o == null ? "null" : o.toString();
  }

  public String substring(int start, int endIndex) {
    return $substring(this, start, endIndex);
  }

  public String substring(int start) {
    return $substring(this, start);
  }

  public String trim() {
    return $trim(this);
  }

  @JsMethod(name = "$isInstance")
  public static boolean isInstance(Object instance) {
    return nativeIsInstance(instance);
  }

  private static native boolean nativeIsInstance(
      Object instance) /*-{return typeof instance == 'string';}-*/;

  private static native int $hashCode(String obj) /*-{
    let hashCode = 0;
    let len = obj.length;
    for (let i = 0; i < len; i++) {
      hashCode += obj.charCodeAt(i) * Math.pow(31, len - i - 1);
    }
    return hashCode;
  }-*/;

  private static native int $length(String obj) /*-{ return obj.length; }-*/;

  private static native char $charAt(String obj, int index) /*-{
    return obj.charCodeAt(index);
  }-*/;

  private static native String $subSequence(String obj, int start, int end) /*-{
    return obj.substring(start, end);
  }-*/;

  private static native String $substring(String obj, int start, int endIndex) /*-{
    return obj.substring(start, endIndex);
  }-*/;

  private static native String $substring(String obj, int start) /*-{
    return obj.substring(start);
  }-*/;

  private static native String $trim(String obj) /*-{ return obj.trim(); }-*/;

  private static native int $compareTo(String one, String other) /*-{
    if (one == other) {
      return 0;
    }
    return one < other ? -1 : 1;
  }-*/;
}
