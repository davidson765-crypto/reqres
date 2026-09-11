package org.example.api.extensions;

import org.example.PropertyReadHelper;
import org.example.api.entities.request.RegisterLoginRequestBody;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UserExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        return parameterContext.getParameter()
                .getType()
                .equals(RegisterLoginRequestBody.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        return RegisterLoginRequestBody.builder()
                .email(PropertyReadHelper.getPropertyCustom("API_EMAIL"))
                .password(PropertyReadHelper.getPropertyKey("API_REGISTRATION_PASSWORD"))
                .build();
    }
}
