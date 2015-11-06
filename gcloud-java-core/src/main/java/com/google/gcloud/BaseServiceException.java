/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud;

/**
 * Base class for all service exceptions.
 */
public class BaseServiceException extends RuntimeException {

  private static final long serialVersionUID = 5028833760039966178L;

  private final int code;
  private final boolean retryable;

  public BaseServiceException(int code, String message, boolean retryable) {
    super(message);
    this.code = code;
    this.retryable = retryable;
  }

  public BaseServiceException(int code, String message, boolean retryable, Exception cause) {
    super(message, cause);
    this.code = code;
    this.retryable = retryable;
  }

  /**
   * Returns the code associated with this exception.
   */
  public int code() {
    return code;
  }

  /**
   * Returns {@code true} when it is safe to retry the operation that caused this exception.
   */
  public boolean retryable() {
    return retryable;
  }
}