package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceCreateStandard;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceCreateView;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 创建工区接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:41
 **/
@Component
public class WorkSpaceCreateConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceCreateConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 创建工区接口入参转换为业务对象
     *
     * @param workSpaceCreateStandard 创建工区入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversion(WorkSpaceCreateStandard workSpaceCreateStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceCreateStandard)) {
            System.out.println("创建工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        workSpace.setWorkSpaceName(workSpaceCreateStandard.getWorkSpaceName());
        workSpace.setWorkSpaceContact(workSpaceCreateStandard.getWorkSpaceContact());
        workSpace.setWorkSpaceAddress(workSpaceCreateStandard.getWorkSpaceAddress());
        workSpace.setWorkSpaceParentId(workSpaceCreateStandard.getWorkSpaceParentId());
        workSpace.setWorkSpaceRemark(workSpaceCreateStandard.getWorkSpaceRemark());
        return workSpace;
    }

    /**
     * 创建工区接口业务对象转换为入参
     *
     * @param workSpace 创建工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceCreateView conversion(WorkSpace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyCreate(workSpace, type)) {
            System.out.println("创建工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        WorkSpaceCreateView workSpaceCreateView = new WorkSpaceCreateView();
        workSpaceCreateView.setWorkSpaceId(workSpace.getWorkSpaceId());
        workSpaceCreateView.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaceCreateView.setWorkSpaceName(workSpace.getWorkSpaceName());
        workSpaceCreateView.setWorkSpaceAddress(workSpace.getWorkSpaceAddress());
        workSpaceCreateView.setWorkSpaceContact(workSpace.getWorkSpaceContact());
        workSpaceCreateView.setWorkSpacePeopleNumber(workSpace.getWorkSpacePeopleNumber());
        workSpaceCreateView.setWorkSpaceRemark(workSpace.getWorkSpaceRemark());
        return workSpaceCreateView;
    }
}
