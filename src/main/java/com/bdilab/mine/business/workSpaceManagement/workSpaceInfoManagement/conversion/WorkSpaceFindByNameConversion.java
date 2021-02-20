package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion;

import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.WorkSpaceFindByNameStandard;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.WorkSpaceFindByNameView;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据工区名称查找工区数据结构转换
 *
 * @author Lian
 * @date 2021/2/20 9:46
 **/
@Component
public class WorkSpaceFindByNameConversion {
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceFindByNameConversion(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    /**
     * 根据工区名称查找工区接口入参转换为业务对象
     *
     * @param workSpaceFindByNameStandard 根据工区名称查找工区入参
     * @return 转换后的业务对象
     */
    public WorkSpace conversion(WorkSpaceFindByNameStandard workSpaceFindByNameStandard) {
        if (!workSpaceInfoManagementVerifyIntegrity.verify(workSpaceFindByNameStandard)) {
            System.out.println("根据工区名称查找工区接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        WorkSpace workSpace = new WorkSpace();
        workSpace.setWorkSpaceName(workSpaceFindByNameStandard.getWorkSpaceName());
        workSpace.setWorkSpaceParentId(workSpaceFindByNameStandard.getWorkSpaceParentId());
        return workSpace;
    }

    /**
     * 根据工区名称查找工区接口业务对象转换为入参
     *
     * @param workSpace 根据工区名称查找工区业务对象
     * @return 转换后的出参
     */
    public WorkSpaceFindByNameView conversion(WorkSpace workSpace) {
        int type = 2;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByParentId(workSpace, type)) {
            System.out.println("根据工区名称查找工区接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
        }
        WorkSpaceFindByNameView workSpaceFindByNameView = new WorkSpaceFindByNameView();
        workSpaceFindByNameView.setWorkSpaceId(workSpace.getWorkSpaceId());
        workSpaceFindByNameView.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaceFindByNameView.setWorkSpaceName(workSpace.getWorkSpaceName());
        workSpaceFindByNameView.setWorkSpaceAddress(workSpace.getWorkSpaceAddress());
        workSpaceFindByNameView.setWorkSpaceContact(workSpace.getWorkSpaceContact());
        workSpaceFindByNameView.setWorkSpacePeopleNumber(workSpace.getWorkSpacePeopleNumber());
        workSpaceFindByNameView.setWorkSpaceRemark(workSpace.getWorkSpaceRemark());
        return workSpaceFindByNameView;
    }
}
