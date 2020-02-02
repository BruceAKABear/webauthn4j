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

package com.webauthn4j.validator;

import com.webauthn4j.data.attestation.authenticator.AttestedCredentialData;
import com.webauthn4j.data.attestation.authenticator.AuthenticatorData;
import com.webauthn4j.validator.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthenticationDataValidatorTest {

    private AuthenticationDataValidator target = new AuthenticationDataValidator();

    @Test
    void validateAuthenticatorData_with_non_null_AttestedCredentialData() {
        AuthenticatorData authenticatorData = mock(AuthenticatorData.class);
        AttestedCredentialData attestedCredentialData = mock(AttestedCredentialData.class);
        when(authenticatorData.getAttestedCredentialData()).thenReturn(attestedCredentialData);
        assertThatThrownBy(() -> target.validateAuthenticatorData(authenticatorData)).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void getCustomAuthenticationValidators() {
        CustomAuthenticationValidator customAuthenticationValidator = mock(CustomAuthenticationValidator.class);
        target.getCustomAuthenticationValidators().add(customAuthenticationValidator);
        assertThat(target.getCustomAuthenticationValidators()).contains(customAuthenticationValidator);
    }
}