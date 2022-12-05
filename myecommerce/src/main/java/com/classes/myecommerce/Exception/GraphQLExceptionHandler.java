package com.classes.myecommerce.Exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if(ex.getClass().equals(InvalidLast4Exception.class)){
            return toGraphQLError(ex);
        }else if(ex.getClass().equals(InvalidCourierException.class)){
            return toGraphQLError(ex);
        }else if(ex.getClass().equals(InvalidBankInformation.class)){
            return toGraphQLError(ex);
        }else if(ex.getClass().equals(InvalidPriceModifier.class)){
            return toGraphQLError(ex);
        }else if(ex.getClass().equals(InvalidPaymentMethod.class)){
            return toGraphQLError(ex);
        }else {
            return super.resolveToSingleError(ex, env);
        }
    }

    private GraphQLError toGraphQLError(Throwable ex){
        return GraphqlErrorBuilder.newError().message(ex.getMessage()).errorType(ErrorType.ValidationError).build();
    }
}
