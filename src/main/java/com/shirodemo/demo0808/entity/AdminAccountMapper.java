package com.shirodemo.demo0808.entity;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated
     */
    int insert(AdminAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated
     */
    List<AdminAccount> selectAll();
}