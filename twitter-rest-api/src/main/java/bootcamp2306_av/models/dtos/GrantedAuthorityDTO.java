package bootcamp2306_av.models.dtos;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityDTO implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}


