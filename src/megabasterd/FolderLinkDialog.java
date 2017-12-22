package megabasterd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import static megabasterd.MainPanel.*;
import static megabasterd.MiscTools.*;

/**
 *
 * @author tonikelope
 */
public final class FolderLinkDialog extends javax.swing.JDialog {

    private final String _link;

    private boolean _download;

    private final List<HashMap> _download_links;

    private long _total_space;

    private boolean _mega_error;

    public List<HashMap> getDownload_links() {
        return Collections.unmodifiableList(_download_links);
    }

    public boolean isDownload() {
        return _download;
    }

    public boolean isMega_error() {
        return _mega_error;
    }

    /**
     * Creates new form FolderLink
     *
     * @param parent
     * @param link
     */
    public FolderLinkDialog(java.awt.Frame parent, boolean modal, String link) {

        super(parent, modal);

        initComponents();

        updateFonts(this.getRootPane(), DEFAULT_FONT, ZOOM_FACTOR);

        _mega_error = false;
        _total_space = 0L;
        _download = false;
        _download_links = new ArrayList<>();
        _link = link;

        swingReflectionInvoke("setText", folder_link_label, link);

        swingReflectionInvoke("setVisible", restore_button, false);

        _loadMegaDirTree();

        if (!_mega_error) {

            _genDownloadLiks();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file_tree_scrollpane = new javax.swing.JScrollPane();
        file_tree = new javax.swing.JTree();
        skip_button = new javax.swing.JButton();
        link_detected_label = new javax.swing.JLabel();
        dance_button = new javax.swing.JButton();
        folder_link_label = new javax.swing.JLabel();
        warning_label = new javax.swing.JLabel();
        skip_rest_button = new javax.swing.JButton();
        restore_button = new javax.swing.JButton();
        total_space_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FolderLink");

        file_tree.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        file_tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        file_tree.setDoubleBuffered(true);
        file_tree.setEnabled(false);
        file_tree_scrollpane.setViewportView(file_tree);

        skip_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        skip_button.setText("REMOVE THIS");
        skip_button.setDoubleBuffered(true);
        skip_button.setEnabled(false);
        skip_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip_buttonActionPerformed(evt);
            }
        });

        link_detected_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        link_detected_label.setText("Folder link detected!");
        link_detected_label.setDoubleBuffered(true);

        dance_button.setBackground(new java.awt.Color(102, 204, 255));
        dance_button.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        dance_button.setForeground(new java.awt.Color(255, 255, 255));
        dance_button.setText("Let's dance, baby");
        dance_button.setDoubleBuffered(true);
        dance_button.setEnabled(false);
        dance_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dance_buttonActionPerformed(evt);
            }
        });

        folder_link_label.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        folder_link_label.setText("jLabel2");
        folder_link_label.setDoubleBuffered(true);

        warning_label.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        warning_label.setText("If you DO NOT want to download some folder or file you can REMOVE it.");
        warning_label.setDoubleBuffered(true);
        warning_label.setEnabled(false);

        skip_rest_button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        skip_rest_button.setText("REMOVE ALL EXCEPT THIS");
        skip_rest_button.setDoubleBuffered(true);
        skip_rest_button.setEnabled(false);
        skip_rest_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip_rest_buttonActionPerformed(evt);
            }
        });

        restore_button.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        restore_button.setText("Restore folder data");
        restore_button.setDoubleBuffered(true);
        restore_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restore_buttonActionPerformed(evt);
            }
        });

        total_space_label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        total_space_label.setText("[0 B]");
        total_space_label.setDoubleBuffered(true);
        total_space_label.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(file_tree_scrollpane)
                    .addComponent(total_space_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(skip_rest_button)
                                .addGap(18, 18, 18)
                                .addComponent(skip_button))
                            .addComponent(link_detected_label)
                            .addComponent(warning_label))
                        .addGap(0, 342, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dance_button))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(folder_link_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restore_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(link_detected_label)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folder_link_label)
                    .addComponent(restore_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(file_tree_scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_space_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning_label)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(dance_button))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(skip_rest_button)
                            .addComponent(skip_button))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skip_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip_buttonActionPerformed

        if (deleteSelectedTreeItems(file_tree)) {

            _genDownloadLiks();

            restore_button.setVisible(true);

            boolean root_childs = ((TreeNode) file_tree.getModel().getRoot()).getChildCount() > 0;

            dance_button.setEnabled(root_childs);

            skip_button.setEnabled(root_childs);

            skip_rest_button.setEnabled(root_childs);
        }

    }//GEN-LAST:event_skip_buttonActionPerformed

    private void dance_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dance_buttonActionPerformed

        _download = true;

        setVisible(false);
    }//GEN-LAST:event_dance_buttonActionPerformed

    private void skip_rest_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip_rest_buttonActionPerformed

        if (deleteAllExceptSelectedTreeItems(file_tree)) {

            _genDownloadLiks();

            restore_button.setVisible(true);

            boolean root_childs = ((TreeNode) file_tree.getModel().getRoot()).getChildCount() > 0;

            dance_button.setEnabled(root_childs);

            skip_button.setEnabled(root_childs);

            skip_rest_button.setEnabled(root_childs);
        }
    }//GEN-LAST:event_skip_rest_buttonActionPerformed

    private void restore_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restore_buttonActionPerformed

        restore_button.setText("Restoring data, please wait...");

        file_tree.setEnabled(false);

        restore_button.setEnabled(false);

        dance_button.setEnabled(false);

        THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {

                _loadMegaDirTree();

                _genDownloadLiks();

                swingReflectionInvoke("setVisible", restore_button, false);

                swingReflectionInvoke("setText", restore_button, "Restore folder data");

                boolean root_childs = ((TreeNode) ((TreeModel) swingReflectionInvokeAndWaitForReturn("getModel", file_tree)).getRoot()).getChildCount() > 0;

                swingReflectionInvoke("setEnabled", new Object[]{restore_button, dance_button, skip_button, skip_rest_button, file_tree}, root_childs);

            }
        });

    }//GEN-LAST:event_restore_buttonActionPerformed

    private void _loadMegaDirTree() {

        try {
            HashMap<String, Object> folder_nodes;

            MegaAPI ma = new MegaAPI();

            String folder_id = findFirstRegex("#F!([^!]+)", _link, 1);

            String folder_key = findFirstRegex("#F![^!]+!(.+)", _link, 1);

            folder_nodes = ma.getFolderNodes(folder_id, folder_key);

            MegaMutableTreeNode root = null;

            for (Object o : folder_nodes.values()) {

                HashMap<String, Object> current_hashmap_node = (HashMap<String, Object>) o;

                MegaMutableTreeNode current_node;

                if (current_hashmap_node.get("jtree_node") == null) {

                    current_node = new MegaMutableTreeNode(current_hashmap_node);

                    current_hashmap_node.put("jtree_node", current_node);

                } else {

                    current_node = (MegaMutableTreeNode) current_hashmap_node.get("jtree_node");
                }

                String parent_id = (String) current_hashmap_node.get("parent");

                root = null;

                do {

                    if (folder_nodes.get(parent_id) != null) {

                        HashMap<String, Object> parent_hashmap_node = (HashMap) folder_nodes.get(parent_id);

                        MegaMutableTreeNode parent_node;

                        if (parent_hashmap_node.get("jtree_node") == null) {

                            parent_node = new MegaMutableTreeNode(parent_hashmap_node);

                            parent_hashmap_node.put("jtree_node", parent_node);

                        } else {

                            parent_node = (MegaMutableTreeNode) parent_hashmap_node.get("jtree_node");
                        }

                        parent_node.add(current_node);

                        parent_id = (String) parent_hashmap_node.get("parent");

                        current_node = parent_node;

                    } else {

                        root = current_node;
                    }

                } while (current_node != root);
            }

            swingReflectionInvokeAndWait("setModel", file_tree, new DefaultTreeModel(sortTree(root)));

            swingReflectionInvoke("setRootVisible", file_tree, root != null ? root.getChildCount() > 0 : false);

            swingReflectionInvoke("setEnabled", file_tree, true);

        } catch (Exception ex) {

            Logger.getLogger(getClass().getName()).log(SEVERE, null, ex);

            _mega_error = true;
        }

    }

    private void _genDownloadLiks() {

        String folder_id = findFirstRegex("#F!([^!]+)", _link, 1);

        _download_links.clear();

        MegaMutableTreeNode root = (MegaMutableTreeNode) ((TreeModel) swingReflectionInvokeAndWaitForReturn("getModel", file_tree)).getRoot();

        Enumeration files_tree = root.depthFirstEnumeration();

        _total_space = 0L;

        while (files_tree.hasMoreElements()) {

            MegaMutableTreeNode node = (MegaMutableTreeNode) files_tree.nextElement();

            if (node.isLeaf() && node != root && ((HashMap<String, Object>) node.getUserObject()).get("size") != null) {

                String path = "";

                Object[] object_path = node.getUserObjectPath();

                for (Object p : object_path) {

                    path += "/" + ((Map<String, Object>) p).get("name");
                }

                path = path.replaceAll("^/+", "").trim();

                String url = "https://mega.nz/#N!" + ((Map<String, Object>) node.getUserObject()).get("h") + "!" + ((Map<String, Object>) node.getUserObject()).get("key") + "###n=" + folder_id;

                HashMap<String, Object> download_link = new HashMap<>();

                download_link.put("url", url);

                download_link.put("filename", cleanFilePath(path));

                download_link.put("filekey", ((Map<String, Object>) node.getUserObject()).get("key"));

                download_link.put("filesize", ((Map<String, Object>) node.getUserObject()).get("size"));

                _total_space += (long) download_link.get("filesize");

                _download_links.add(download_link);
            }
        }

        swingReflectionInvoke("setText", total_space_label, "[" + formatBytes(_total_space) + "]");

        swingReflectionInvoke("setEnabled", new Object[]{dance_button, warning_label, skip_button, skip_rest_button, total_space_label}, root.getChildCount() > 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dance_button;
    private javax.swing.JTree file_tree;
    private javax.swing.JScrollPane file_tree_scrollpane;
    private javax.swing.JLabel folder_link_label;
    private javax.swing.JLabel link_detected_label;
    private javax.swing.JButton restore_button;
    private javax.swing.JButton skip_button;
    private javax.swing.JButton skip_rest_button;
    private javax.swing.JLabel total_space_label;
    private javax.swing.JLabel warning_label;
    // End of variables declaration//GEN-END:variables
}
