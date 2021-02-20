package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.UserFindByWorkSpaceIdStandard;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.UserFindByWorkSpaceIdView;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据工区编号查找用户数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:50
 **/
@Component
public class UserFindByWorkSpaceIdConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public UserFindByWorkSpaceIdConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 根据工区编号查找用户接口入参转换为业务对象
     *
     * @param userFindByWorkSpaceIdStandard 根据工区编号查找用户入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversion(UserFindByWorkSpaceIdStandard userFindByWorkSpaceIdStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(userFindByWorkSpaceIdStandard)) {
            System.out.println("根据工区编号查找用户接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(userFindByWorkSpaceIdStandard.getWorkSpaceId());
        return workSpace;
    }

    /**
     * 根据工区编号查找用户接口业务对象转换为入参
     *
     * @param user 根据工区编号查找用户业务对象
     * @return 转换后的出参
     */
    public UserFindByWorkSpaceIdView conversion(User user) {
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByWorkSpaceIdUser(user)) {
            System.out.println("根据工区编号查找用户接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        UserFindByWorkSpaceIdView userFindByWorkSpaceIdView = new UserFindByWorkSpaceIdView();
        userFindByWorkSpaceIdView.setUserMobile(user.getUserMobile());
        userFindByWorkSpaceIdView.setUserName(user.getUserName());
        userFindByWorkSpaceIdView.setUserEmail(user.getUserEmail());
        userFindByWorkSpaceIdView.setUserOrganizationId(user.getUserOrganizationId());
        userFindByWorkSpaceIdView.setUserWorkSpaceId(user.getUserWorkSpaceId());
        userFindByWorkSpaceIdView.setUserRemark(user.getUserRemark());
        return userFindByWorkSpaceIdView;
    }
}
