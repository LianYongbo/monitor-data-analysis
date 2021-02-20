package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.UserTransferStandard;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.UserTransferView;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 调动工区内用户数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:50
 **/
@Component
public class UserTransferConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public UserTransferConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 调动工区内用户接口入参转换为工区业务对象
     *
     * @param userTransferStandard 调动工区内用户入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversionToWorkSpace(UserTransferStandard userTransferStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(userTransferStandard)) {
            System.out.println("调动工区内用户接口 - 入参转换工区业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(userTransferStandard.getWorkSpaceId());
        return workSpace;
    }

    /**
     * 调动工区内用户接口入参转换为用户业务对象
     *
     * @param userTransferStandard 调动工区内用户入参
     * @return 转换后的业务对象
     */
    public User conversionToUser(UserTransferStandard userTransferStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(userTransferStandard)) {
            System.out.println("调动工区内用户接口 - 入参转换工区用户对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        User user = new User();
        user.setUserMobile(userTransferStandard.getUserMobile());
        return user;
    }

    /**
     * 是否调入用户
     *
     * @param userTransferStandard 调动工区内用户入参
     * @return true：调入；false：调出
     */
    public Boolean isAdd(UserTransferStandard userTransferStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(userTransferStandard)) {
            System.out.println("调动工区内用户接口 - isAdd - " + new Date() + " - 入参有误！");
            return null;
        }
        return userTransferStandard.getWorkSpaceAdd();
    }

    /**
     * 调动工区内用户接口业务对象转换为出参
     *
     * @param user 调动工区内用户业务对象
     * @return 转换后的出参
     */
    public UserTransferView conversion(User user) {
        if (!workSpaceInfoManagementVerifyIntegrity.verifyTransferUser(user)) {
            System.out.println("调动工区内用户接口 - 用户业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        UserTransferView userTransferView = new UserTransferView();
        userTransferView.setUserMobile(user.getUserMobile());
        userTransferView.setUserWorkSpaceId(user.getUserWorkSpaceId());
        return userTransferView;
    }
}
