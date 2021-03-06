/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.test.authenticator.u2f;

import com.webauthn4j.util.WIP;

@WIP
public class RegistrationRequest {

    private byte[] challengeParameter;
    private byte[] applicationParameter;

    public RegistrationRequest(byte[] challengeParameter, byte[] applicationParameter) {
        if (challengeParameter.length != 32) {
            throw new IllegalArgumentException("challengeParameter must be 32 bytes");
        }
        if (applicationParameter.length != 32) {
            throw new IllegalArgumentException("applicationParameter must be 32 bytes");
        }

        this.challengeParameter = challengeParameter;
        this.applicationParameter = applicationParameter;
    }

    public byte[] getChallengeParameter() {
        return challengeParameter;
    }

    public byte[] getApplicationParameter() {
        return applicationParameter;
    }
}
