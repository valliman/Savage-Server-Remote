package view;

import controller.Tool;
import model.ConnectionManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.07.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public class MainForm extends JFrame{
    private JButton logoutButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTextField consoleTextField;
    private JButton consoleSendButton;
    private JComboBox objectEditorComboBox;
    private JTable objectEditorTable;
    private JButton objectEditorApplyButton;
    private JButton objectEditorReloadDataButton;
    private JButton objectEditorSaveButton;
    private JComboBox stateEditorComboBox;
    private JTable stateEditorTable;
    private JButton stateEditorApplyButton;
    private JButton stateEditorReloadDataButton;
    private JButton stateEditorSaveButton;
    private JButton restartMatchButton;
    private JButton drawButton;
    private JButton extendTimelimitButton;
    private JButton pauseButton;
    private JButton unpauseButton;
    private JTextField broadcastMessageTextField;
    private JButton broadcastMessageSendButton;
    private JButton loadMapButton;
    private JButton uploadMapButton;
    private JButton mapRotationButton;
    private JButton nextMapButton;
    private JTextField xpMultiplierTextField;
    private JTextField xpOnConnectTextField;
    private JTextField honorTextField;
    private JTextField skillTextField;
    private JTextField heroTextField;
    private JTextField legendTextField;
    private JTextField playerBuildTextField;
    private JTextField repairTextField;
    private JTextField mineTextField;
    private JTextField killNPCTextField;
    private JTextField killWorkerTextField;
    private JTextField killPlayerTextField;
    private JTextField killSiegeTextField;
    private JTextField killItemTextField;
    private JTextField hitBuildingTextField;
    private JTextField lastHitOnBuildingTextField;
    private JTextField healPlayerTextField;
    private JTextField revivePlayerTextField;
    private JTextField orderGivenTextField;
    private JTextField orderFollowedTextField;
    private JTextField resourcesGatheredTextField;
    private JTextField powerupGivenTextField;
    private JTextField commanderBuildTextField;
    private JTextField researchTextField;
    private JTextField destroyEnemyBuildingTextField;
    private JTextField specAccelerationTextField;
    private JTextField playerSpeedTextField;
    private JTextField gravityTextField;
    private JTextField frictionTextField;
    private JTextField airControlTextField;
    private JTextField sprintSpeedTextField;
    private JTextField stepHeightTextField;
    private JTextField jumpHeightTextField;
    private JTextField jumpStaminaCostTextField;
    private JTextField leapStaminaCostTextField;
    private JTextField staminaDepleteSpeedTextField;
    private JTextField sprintRegenSlowTextField;
    private JTextField sprintRegenFastTextField;
    private JTextField sprintDeadZoneTextField;
    private JTextField sprintRegainDelayTextField;
    private JTextField sprintRegainLandDelayTextField;
    private JTextField maxBlockTimeTextField;
    private JTextField blockSpeedTextField;
    private JTextField slowWeaponAttackTextField;
    private JTextField attackingSpeedTextField;
    private JTextField minSlopeTextField;
    private JTextField minFallDamage;
    private JTextField maxPushTextField;
    private JTextField uphillLeapTimeTextField;
    private JTextField pushRangeTextField;
    private JTextField pushForceTextField;
    private JTextField grabRangeTextField;
    private JTextField throwForceTextField;
    private JTextField quakeMultiplierTextField;
    private JCheckBox disableVotingCheckBox;
    private JCheckBox concedeVotesCheckBox;
    private JCheckBox drawVotesCheckBox;
    private JCheckBox electVotesCheckBox;
    private JCheckBox impeachVotesCheckBox;
    private JCheckBox kickVotesCheckBox;
    private JCheckBox mapVotesCheckBox;
    private JCheckBox messageVotesCheckBox;
    private JCheckBox muteVotesCheckBox;
    private JCheckBox nextMapVotesCheckBox;
    private JCheckBox pauseVotesCheckBox;
    private JCheckBox unpauseVotesCheckBox;
    private JCheckBox raceVotesCheckBox;
    private JCheckBox refVotesCheckBox;
    private JCheckBox restartVotesCheckBox;
    private JCheckBox shuffleVotesCheckBox;
    private JCheckBox timeVotesCheckBox;
    private JTextField voteDurationTextField;
    private JTextField minVotePercentTextField;
    private JTextField forceCommanderPlayerLimitTextField;
    private JCheckBox enableGoodieBagsCheckBox;
    private JComboBox allowPickupComboBox;
    private JTextField durationTextField;
    private JTextField playerOnlyTimeTextField;
    private JTextField maxValueTextField;
    private JTextField jackpotChanceTextField;
    private JTextField ammoChanceTextField;
    private JCheckBox allowWorkAnimationsCheckBox;
    private JCheckBox allowMineDepletionCheckBox;
    private JCheckBox allowTaxChangeCheckBox;
    private JCheckBox buyStuffForFreeCheckBox;
    private JTextField startingStoneTextField;
    private JTextField startingGoldTextField;
    private JButton zero2three;
    private JButton three2zero;
    private JButton zero2one;
    private JButton one2zero;
    private JButton two2zero;
    private JButton zero2two;
    private JButton four2zero;
    private JButton zero2four;
    private JButton kickButton;
    private JButton muteButton;
    private JButton unmuteButton;
    private JButton setCommanderButton;
    private JButton impeachButton;
    private JButton shuffleEvenTeamsButton;
    private JComboBox comboBox4;
    private JButton applyButton2;
    private JTable settingsEditorTable;
    private JButton settingsEditorReloadDataButton;
    private JButton settingsEditorApplyButton;
    private JButton generalReloadDataButton;
    private JButton generalApplyButton;
    private JButton advanced1ReloadDataButton;
    private JButton votesReloadDataButton;
    private JButton votesApplyButton;
    private JButton resourcesReloadDataButton;
    private JButton resourcesApplyButton;
    private JButton experienceReloadDataButton;
    private JButton experienceApplyButton;
    private JButton physicsReloadDataButton;
    private JButton physicsApplyButton;
    private JTextField serverNameTextField;
    private JComboBox team1ComboBox;
    private JComboBox team2ComboBox;
    private JComboBox team3ComboBox;
    private JComboBox team4ComboBox;
    private JTextField motd1TextField;
    private JTextField motd2TextField;
    private JTextField motd3TextField;
    private JTextField motd4TextField;
    private JTextField motd5TextField;
    private JTextField motd6TextField;
    private JTextField joinPasswordTextField;
    private JTextField adminPasswordTextField;
    private JTextField refereePasswordTextField;
    private JTextField godRefPasswordTextField;
    private JTextField maxPlayersTextField;
    private JTextField serverNotesTextField;
    private JCheckBox balancedTeamsCheckBox;
    private JTextField connectMoneyTextField;
    private JTextField maxMoneyTextField;
    private JTextField reviveMoneyRewardTextField;
    private JTextField readyPercentTextField;
    private JCheckBox allowSpawningAtAllCheckBox;
    private JCheckBox infiniteGoldAtWarmupCheckBox;
    private JCheckBox enableAllTechsAtWarmupCheckBox;
    private JCheckBox allowAnyoneCheckBox;
    private JCheckBox allowOfficersCheckBox;
    private JCheckBox allowCommandersCheckBox;
    private JCheckBox allowGlobalVOIPChattingCheckBox;
    private JCheckBox allowTeamVOIPChattingCheckBox;
    private JCheckBox allowSquadVOIPChattingCheckBox;
    private JTextField maxStreamTimeTextField;
    private JTextField streamWaitTimeTextField;
    private JCheckBox broadcastServerCheckBox;
    private JCheckBox sendStatsCheckBox;
    private JButton advanced1ApplyButton;
    private JCheckBox enableSquadsCheckBox;
    private JCheckBox squadAutoAssignCheckBox;
    private JTextField maxOfficerTextField;
    private JTextField clientsPerOfficerTextField;
    private JTextField autoSquadMinimumTextField;
    private JTextField squadMembersPerSquadOfficerTextField;
    private JTextField teamSwitchDelayTextField;
    private JTextField teamSwitchFreedomTextField;
    private JTextField respawnTimeTextField;
    private JTextField resurrectTimeTextField;
    private JTextField invincibleTimeTextField;
    private JTextField invincibleTimeRespawnFactorTextField;
    private JTextField skillfullKillDistanceTextField;
    private JTextField blockArcMultiplierTextField;
    private JButton advanced2ReloadDataButton;
    private JButton advanced2ApplyButton;
    private JCheckBox claimableBuildingsCheckBox;
    private JCheckBox repairCostsCheckBox;
    private JCheckBox overtimeDecayCheckBox;
    private JTextField buildingTestScaleTextField;
    private JTextField minClaimIntervalTextField;
    private JTextField repairCostFactorTextField;
    private JTextField buildingDamageRateTextField;
    private JTextField decayRateTextField;
    private JTextField minBuildingHPTextField;
    private JTextField maintainBuildingHPCostTextField;
    private JCheckBox preventRelocExploitsCheckBox;
    private JCheckBox allowItemDropActionCheckBox;
    private JCheckBox allowItemDropOnDeathCheckBox;
    private JCheckBox allowToPickupEnemyCheckBox;
    private JTextField minLandmineDistanceTextField;
    private JTextField bouncingProjectileRestVelocityTextField;
    private JTextField bouncingProjectileRestSlopeTextField;
    private JTextField droppedItemExpiryTimeTextField;
    private JTextField droppedItemPickupDistanceTextField;
    private JCheckBox allowTeamDamageCheckBox;
    private JCheckBox allowMeleeTeamDamageCheckBox;
    private JCheckBox allowWeaponTeamDamageCheckBox;
    private JCheckBox allowSiegeTeamDamageCheckBox;
    private JCheckBox allowTowerTeamDamageCheckBox;
    private JTextField teamDamagePercentTextField;
    private JCheckBox allowDemoListingCheckBox;
    private JTextField replayFolderTextField;
    private JTextField demoFolderTextField;
    private JCheckBox demoRecordVotesCheckBox;
    private JCheckBox demoReplayVotesCheckBox;
    private JButton reloadDataButton10;
    private JTextField specSpeedTextField;
    private JPanel contentPane;
    private JCheckBox fallingDamageCheckBox;
    private JCheckBox uphillLeapCheckBox;
    private JLabel currentMapLabel;
    private JLabel nextMapLabel;
    private JButton overviewReloadDataButton;
    private JButton playerListReloadDataButton;
    private JCheckBox allowItemTeamDamageCheckBox;
    private JCheckBox replayDemosCheckBox;
    private JCheckBox recordDemosCheckBox;
    private JCheckBox modVotesCheckBox;
    private JCheckBox sprintBurstCheckBox;
    private JTextArea consoleTextArea;
    private JScrollPane consoleTextScrollPane;
    private JLabel serverNameLabel;
    private JLabel worldLabel;
    private JLabel versionLabel;
    private JLabel playersLabel;
    private JLabel timePlayedLabel;
    private JLabel timeLeftLabel;
    private JLabel overviewMapImageLabel;
    private JCheckBox allUnitsAvailableCheckBox;
    private JCheckBox allWeaponsAvailableCheckBox;
    private JCheckBox infiniteGoldCheckBox;
    private JCheckBox infiniteResourcesCheckBox;
    private JCheckBox devBalancedTeamsCheckBox;
    private JCheckBox fastBuildCheckBox;
    private JButton devReloadDataButton;
    private JButton devApplyButton;
    private JList playerListTeam1;
    private JList playerListTeam0;
    private JList playerListTeam2;
    private JList playerListTeam3;
    private JList playerListTeam4;
    private ConnectionManager cman;
    private HashMap<String,String> reloadconfig;
    private HashMap<String,String> reloadobject;
    private HashMap<String,String> appliedobject;
    private HashMap<String,String> reloadstate;
    private HashMap<String,String> appliedstate;
    private HashMap<String,String> playerlist;

    public MainForm(ConnectionManager cman) {
        setTitle("Savage Remote Controller Pro");
        setExtendedState(this.MAXIMIZED_BOTH);
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cman=cman;
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogOut();
            }
        });
        extendTimelimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExtendTime();
            }
        });
        broadcastMessageSendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBroadcastMessageSend();
            }
        });
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDraw();
            }
        });
        restartMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRestartMatch();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPause();
            }
        });
        unpauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUnpause();
            }
        });
        nextMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onNextMap();
            }
        });
        generalApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGeneralApply();
            }
        });
        generalReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGeneralReloadData();
            }
        });
        advanced1ApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced1Apply();
            }
        });
        advanced1ReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced1ReloadData();
            }
        });
        advanced2ApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced2Apply();
            }
        });
        recordDemosCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onRecordDemos();
            }
        });
        replayDemosCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onReplayDemos();
            }
        });
        advanced2ReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdvanced2ReloadData();
            }
        });
        allowTeamDamageCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onTeamDamage();
            }
        });
        votesApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onVotesApply();
            }
        });
        disableVotingCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onDisableVotes();
            }
        });
        votesReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onVotesReloadData();
            }
        });
        resourcesApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onResourcesApply();
            }
        });
        enableGoodieBagsCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                enableGoodieBags();
            }
        });
        resourcesReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onResourcesReloadData();
            }
        });
        experienceApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExperienceApply();
            }
        });
        experienceReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExperienceReloadData();
            }
        });
        fallingDamageCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onFallingDamage();
            }
        });
        uphillLeapCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onUphillLeap();
            }
        });
        allowItemDropActionCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onAllowItemDropAction();
            }
        });
        repairCostsCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onRepairCosts();
            }
        });
        enableSquadsCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onEnableSquads();
            }
        });
        physicsApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPhysicsApply();
            }
        });
        physicsReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPhysicsReloadData();
            }
        });
        consoleSendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onConsoleSend();
            }
        });
        consoleTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    onConsoleSend();
                }
            }
        });
        pack();
        setVisible(true);

        overviewReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOverviewReloadData();
            }
        });
        loadMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoadMap();
            }
        });
        uploadMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUploadMap();
            }
        });
        devReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDevReloadData();
            }
        });
        devApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDevApply();
            }
        });
        settingsEditorReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSettingsEditorReloadData();
            }
        });
        settingsEditorApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSettingsEditorApply();
            }
        });
        settingsEditorTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        objectEditorReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onObjectEditorReloadData();
            }
        });
        objectEditorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onObjectEditorComboBoxChange();
            }
        });
        objectEditorApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onObjectEditorApply();
            }
        });
        objectEditorSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onObjectEditorSave();
            }
        });
        stateEditorReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onStateEditorReloadData();
            }
        });
        stateEditorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onStateEditorComboBoxChange();
            }
        });
        stateEditorApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onStateEditorApply();
            }
        });
        stateEditorSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onStateEditorSave();
            }
        });
        playerListReloadDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPlayerListReloadData();
            }
        });
        zero2one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onZero2One();
            }
        });
        one2zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOne2Zero();
            }
        });
        two2zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTwo2Zero();
            }
        });
        zero2two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onZero2Two();
            }
        });
        zero2three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onZero2Three();
            }
        });
        three2zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onThree2Zero();
            }
        });
        four2zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFour2Zero();
            }
        });
        zero2four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onZero2Four();
            }
        });
        playerListTeam0.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onPlayerListTeam0Click();
            }
        });
        playerListTeam1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onPlayerListTeam1Click();
            }
        });
        playerListTeam2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onPlayerListTeam2Click();
            }
        });
        playerListTeam3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onPlayerListTeam3Click();
            }
        });
        playerListTeam4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                onPlayerListTeam4Click();
            }
        });
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMute();
            }
        });
        unmuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUnmute();
            }
        });
        kickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onKick();
            }
        });
        setCommanderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSetCommander();
            }
        });
        impeachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onImpeach();
            }
        });
        shuffleEvenTeamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onShuffleEvenTeams();
            }
        });
    }

    private void onShuffleEvenTeams() {
        cman.shuffleteams();
    }

    private void onImpeach() {
        int team=0;
        if(playerListTeam0.getSelectedIndex()!=-1) {
            team=0;
        }
        if(playerListTeam1.getSelectedIndex()!=-1) {
            team=1;
        }
        if(playerListTeam2.getSelectedIndex()!=-1) {
            team=2;
        }
        if(playerListTeam3.getSelectedIndex()!=-1) {
            team=3;
        }
        if(playerListTeam4.getSelectedIndex()!=-1) {
            team=4;
        }
        cman.switchteam(team,getSelectedName());
    }

    private void onSetCommander() {
        cman.setcmdr(getSelectedName());
    }

    private void onKick() {
        cman.kick(getSelectedName());
    }

    private void onUnmute() {
        cman.unmute(getSelectedName());
    }

    private void onMute() {
        cman.mute(getSelectedName());
    }

    private void onPlayerListTeam0Click() {
        playerListTeam1.removeSelectionInterval(0, playerListTeam1.getModel().getSize());
        playerListTeam2.removeSelectionInterval(0, playerListTeam2.getModel().getSize());
        playerListTeam3.removeSelectionInterval(0, playerListTeam3.getModel().getSize());
        playerListTeam4.removeSelectionInterval(0, playerListTeam4.getModel().getSize());
    }

    private void onPlayerListTeam1Click() {
        playerListTeam0.removeSelectionInterval(0, playerListTeam0.getModel().getSize());
        playerListTeam2.removeSelectionInterval(0, playerListTeam2.getModel().getSize());
        playerListTeam3.removeSelectionInterval(0, playerListTeam3.getModel().getSize());
        playerListTeam4.removeSelectionInterval(0, playerListTeam4.getModel().getSize());
    }

    private void onPlayerListTeam2Click() {
        playerListTeam1.removeSelectionInterval(0, playerListTeam1.getModel().getSize());
        playerListTeam0.removeSelectionInterval(0, playerListTeam0.getModel().getSize());
        playerListTeam3.removeSelectionInterval(0, playerListTeam3.getModel().getSize());
        playerListTeam4.removeSelectionInterval(0, playerListTeam4.getModel().getSize());
    }

    private void onPlayerListTeam3Click() {
        playerListTeam1.removeSelectionInterval(0, playerListTeam1.getModel().getSize());
        playerListTeam2.removeSelectionInterval(0, playerListTeam2.getModel().getSize());
        playerListTeam0.removeSelectionInterval(0, playerListTeam0.getModel().getSize());
        playerListTeam4.removeSelectionInterval(0, playerListTeam4.getModel().getSize());
    }

    private void onPlayerListTeam4Click() {
        playerListTeam1.removeSelectionInterval(0, playerListTeam1.getModel().getSize());
        playerListTeam2.removeSelectionInterval(0, playerListTeam2.getModel().getSize());
        playerListTeam3.removeSelectionInterval(0, playerListTeam3.getModel().getSize());
        playerListTeam0.removeSelectionInterval(0, playerListTeam0.getModel().getSize());
    }

    private String getSelectedName() {
        if(playerListTeam0.getSelectedIndex()!=-1) {
            return playerListTeam0.getSelectedValue().toString();
        }
        else if(playerListTeam1.getSelectedIndex()!=-1) {
            return playerListTeam1.getSelectedValue().toString();
        }
        else if(playerListTeam2.getSelectedIndex()!=-1) {
            return playerListTeam2.getSelectedValue().toString();
        }
        else if(playerListTeam3.getSelectedIndex()!=-1) {
            return playerListTeam3.getSelectedValue().toString();
        }
        else if(playerListTeam4.getSelectedIndex()!=-1) {
            return playerListTeam4.getSelectedValue().toString();
        }
        else {
            return "";
        }
    }

    private void onZero2One() {
        if(playerListTeam0.getSelectedIndex()!=-1) {
            cman.switchteam(1, playerListTeam0.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onOne2Zero() {
        if(playerListTeam1.getSelectedIndex()!=-1) {
            cman.switchteam(0, playerListTeam1.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onZero2Two() {
        if(playerListTeam0.getSelectedIndex()!=-1) {
            cman.switchteam(2, playerListTeam0.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onTwo2Zero() {
        if(playerListTeam2.getSelectedIndex()!=-1) {
            cman.switchteam(0, playerListTeam2.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onZero2Three() {
        if(playerListTeam0.getSelectedIndex()!=-1) {
            cman.switchteam(3, playerListTeam0.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onThree2Zero() {
        if(playerListTeam3.getSelectedIndex()!=-1) {
            cman.switchteam(0, playerListTeam3.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onZero2Four() {
        if(playerListTeam0.getSelectedIndex()!=-1) {
            cman.switchteam(4, playerListTeam0.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onFour2Zero() {
        if(playerListTeam4.getSelectedIndex()!=-1) {
            cman.switchteam(0, playerListTeam4.getSelectedValue().toString());
            onPlayerListReloadData();
        }
    }

    private void onPlayerListReloadData() {
        playerlist=cman.getPlayerList();
        DefaultListModel lm0=new DefaultListModel();
        DefaultListModel lm1=new DefaultListModel();
        DefaultListModel lm2=new DefaultListModel();
        DefaultListModel lm3=new DefaultListModel();
        DefaultListModel lm4=new DefaultListModel();
        for(Map.Entry<String,String> client:playerlist.entrySet()) {
            if(client.getValue().equals("0")) {
                lm0.addElement(client.getKey());
            }
            if(client.getValue().equals("1")) {
                lm1.addElement(client.getKey());
            }
            if(client.getValue().equals("2")) {
                lm2.addElement(client.getKey());
            }
            if(client.getValue().equals("3")) {
                lm3.addElement(client.getKey());
            }
            if(client.getValue().equals("4")) {
                lm4.addElement(client.getKey());
            }
        }
        playerListTeam0.setModel(lm0);
        playerListTeam1.setModel(lm1);
        playerListTeam2.setModel(lm2);
        playerListTeam3.setModel(lm3);
        playerListTeam4.setModel(lm4);
    }

    private void onStateEditorSave() {
        HashMap<String,String> applystate=Tool.TableModel2HashMap(stateEditorTable.getModel());
        cman.saveState(Tool.getChange(reloadstate, applystate));
        appliedstate=applystate;
    }

    private void onStateEditorApply() {
        HashMap<String,String> applystate=Tool.TableModel2HashMap(stateEditorTable.getModel());
        cman.applyState(Tool.getChange(reloadstate, applystate));
        appliedstate=applystate;
    }

    private void onStateEditorComboBoxChange() {
        HashMap<String,String> applystate=Tool.TableModel2HashMap(stateEditorTable.getModel());
        if(Tool.isDifferent(appliedstate,applystate)) {
            QuestionDialog qd=new QuestionDialog("","Are you sure you want to discard your changes?");
            if(qd.getAnswer()) {
                reloadstate=Tool.extendState(cman.getState(stateEditorComboBox.getSelectedItem().toString()));
                appliedstate=reloadstate;
                stateEditorTable.setModel(Tool.HashMap2TableModel(reloadstate));
            }
            else {
                onStateEditorApply();
                reloadstate=Tool.extendState(cman.getState(stateEditorComboBox.getSelectedItem().toString()));
                appliedstate=reloadstate;
                stateEditorTable.setModel(Tool.HashMap2TableModel(reloadstate));
            }
        }
        else {
            reloadstate=Tool.extendState(cman.getState(stateEditorComboBox.getSelectedItem().toString()));
            appliedstate=reloadstate;
            stateEditorTable.setModel(Tool.HashMap2TableModel(reloadstate));
        }
    }

    private void onStateEditorReloadData() {
        stateEditorComboBox.removeAllItems();
        String liststates=cman.get("liststates");
        liststates=liststates.replace(" ","");
        liststates=liststates.replace("^rSTATELIST\n","");
        liststates=liststates.replace("^w","");
        String[] temp=liststates.split("\n");
        for(String s:temp) {
            stateEditorComboBox.addItem(s.split(":")[1]);
        }
        reloadstate=Tool.extendState(cman.getState(stateEditorComboBox.getSelectedItem().toString()));
        appliedstate=reloadstate;
        stateEditorTable.setModel(Tool.HashMap2TableModel(reloadstate));
    }

    private void onObjectEditorSave() {
        HashMap<String,String> applyobject=Tool.TableModel2HashMap(objectEditorTable.getModel());
        cman.saveObject(Tool.getChange(reloadobject, applyobject));
        appliedobject=applyobject;
    }

    private void onObjectEditorApply() {
        HashMap<String,String> applyobject=Tool.TableModel2HashMap(objectEditorTable.getModel());
        cman.applyObject(Tool.getChange(reloadobject, applyobject));
        appliedobject=applyobject;
    }

    private void onObjectEditorComboBoxChange() {
        HashMap<String,String> applyobject=Tool.TableModel2HashMap(objectEditorTable.getModel());
        if(Tool.isDifferent(appliedobject,applyobject)) {
            QuestionDialog qd=new QuestionDialog("","Are you sure you want to discard your changes?");
            if(qd.getAnswer()) {
                reloadobject=Tool.extendObject(cman.getObject(objectEditorComboBox.getSelectedItem().toString()));
                appliedobject=reloadobject;
                objectEditorTable.setModel(Tool.HashMap2TableModel(reloadobject));
            }
            else {
                onObjectEditorApply();
                reloadobject=Tool.extendObject(cman.getObject(objectEditorComboBox.getSelectedItem().toString()));
                appliedobject=reloadobject;
                objectEditorTable.setModel(Tool.HashMap2TableModel(reloadobject));
            }
        }
        else {
            reloadobject=Tool.extendObject(cman.getObject(objectEditorComboBox.getSelectedItem().toString()));
            appliedobject=reloadobject;
            objectEditorTable.setModel(Tool.HashMap2TableModel(reloadobject));
        }
    }

    private void onObjectEditorReloadData() {
        objectEditorComboBox.removeAllItems();
        String objshow=cman.get("objshow");
        objshow=objshow.replace(" ","");
        objshow=objshow.replace("^rOBJECTSLIST\n","");
        objshow=objshow.replace("^w","");
        String[] temp=objshow.split("\n");
        for(String s:temp) {
                objectEditorComboBox.addItem(s.split(":")[1]);
        }
        reloadobject=Tool.extendObject(cman.getObject(objectEditorComboBox.getSelectedItem().toString()));
        appliedobject=reloadobject;
        objectEditorTable.setModel(Tool.HashMap2TableModel(reloadobject));
    }

    private void onSettingsEditorApply() {
        HashMap<String,String> applyconfig=Tool.TableModel2HashMap(settingsEditorTable.getModel());
        cman.set(Tool.getChange(reloadconfig,applyconfig));
        reloadconfig=applyconfig;
    }

    private void onSettingsEditorReloadData() {
        reloadconfig=cman.getAll();
        settingsEditorTable.setModel(Tool.HashMap2TableModel(reloadconfig));
        RowSorter sorter = settingsEditorTable.getRowSorter();
        sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
    }

    private void onDevApply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("g_allunitsavailable",allUnitsAvailableCheckBox.isSelected()?"1":"0");
        config.put("g_allweaponsavailable",allWeaponsAvailableCheckBox.isSelected()?"1":"0");
        config.put("sv_infinitegold",infiniteGoldCheckBox.isSelected()?"1":"0");
        config.put("sv_infiniteresources",infiniteResourcesCheckBox.isSelected()?"1":"0");
        config.put("sv_balancedteams",devBalancedTeamsCheckBox.isSelected()?"1":"0");
        config.put("sv_fasttech",fastBuildCheckBox.isSelected()?"1":"0");
        cman.set(config);
    }

    private void onDevReloadData() {
        String[] names={
                "g_allunitsavailable",
                "g_allweaponsavailable",
                "sv_infinitegold",
                "sv_infiniteresources",
                "sv_balancedteams",
                "sv_fasttech"
        };
        HashMap<String,String> config=cman.get(names);
        if(config.get("g_allunitsavailable").equals("1")) {
            allUnitsAvailableCheckBox.setSelected(true);
        }
        else {
            allUnitsAvailableCheckBox.setSelected(false);
        }
        if(config.get("g_allweaponsavailable").equals("1")) {
            allWeaponsAvailableCheckBox.setSelected(true);
        }
        else {
            allWeaponsAvailableCheckBox.setSelected(false);
        }
        if (config.get("sv_infinitegold").equals("1")) {
            infiniteGoldCheckBox.setSelected(true);
        }
        else {
            infiniteGoldCheckBox.setSelected(false);
        }
        if (config.get("sv_infiniteresources").equals("1")) {
            infiniteResourcesCheckBox.setSelected(true);
        }
        else {
            infiniteResourcesCheckBox.setSelected(false);
        }
        if (config.get("sv_balancedteams").equals("1")) {
            devBalancedTeamsCheckBox.setSelected(true);
        }
        else {
            devBalancedTeamsCheckBox.setSelected(false);
        }
        if (config.get("sv_fasttech").equals("1")) {
            fastBuildCheckBox.setSelected(true);
        }
        else {
            fastBuildCheckBox.setSelected(false);
        }
    }

    private void onUploadMap() {
        new UploadMapForm(cman);
    }

    private void onLoadMap() {
        new LoadMapForm(cman);
    }

    private void onOverviewReloadData() {
        String[] names={
            "svr_name",
            "svr_world",
            "sv_map_tag",
            "gs_team0_players",
            "gs_team1_players",
            "gs_team2_players",
            "gs_team3_players",
            "gs_team4_players",
            "svr_maxclients",
            "gs_game_time",
            "sv_timeLimit",
            "sv_nextmap"
        };
        HashMap<String,String> config=cman.get(names);
        serverNameLabel.setText(config.get("svr_name"));
        worldLabel.setText(config.get("svr_world"));
        versionLabel.setText(config.get("sv_map_tag"));
        int players=Integer.parseInt(config.get("gs_team0_players"))+Integer.parseInt(config.get("gs_team1_players"))+Integer.parseInt(config.get("gs_team2_players"))+Integer.parseInt(config.get("gs_team3_players"))+Integer.parseInt(config.get("gs_team4_players"));
        int maxplayers=Integer.parseInt(config.get("svr_maxclients"));
        playersLabel.setText(""+players+"/"+maxplayers);
        int msplayed=Integer.parseInt(config.get("gs_game_time"));
        int mplayed=msplayed/60000;
        int splayed=(int)((float)((msplayed%60000)/1000));
        String tpm=""+mplayed;
        String tps=""+splayed;
        if(tpm.length()<2) tpm="0"+tpm;
        if(tps.length()<2) tps="0"+tps;
        timePlayedLabel.setText(tpm+":"+tps);
        int mslimit=Integer.parseInt(config.get("sv_timeLimit"));
        int msleft=mslimit-msplayed;
        int mleft=msleft/60000;
        int sleft=(int)((float)((msleft%60000)/1000));
        String tlm=""+mleft;
        String tls=""+sleft;
        if(tlm.length()<2) tlm="0"+tlm;
        if(tls.length()<2) tls="0"+tls;
        if(mleft>=0 && sleft>=0) timeLeftLabel.setText(tlm+":"+tls);
        else timeLeftLabel.setText("OVERTIME");
        currentMapLabel.setText(config.get("svr_world"));
        nextMapLabel.setText(config.get("sv_nextmap"));
        overviewMapImageLabel.setIcon(Tool.getMapImage(config.get("svr_world"),128,128));
    }

    private void onConsoleSend() {
        consoleTextArea.setText(consoleTextArea.getText()+ "> " + consoleTextField.getText() + "\n" + cman.execute(consoleTextField.getText()) + "\n\n");
        consoleTextField.setText("");
    }

    private void onPhysicsReloadData() {
        String[] names={
            "p_specspeed",
            "p_freeflyAccel",
            "p_speed",
            "p_gravity",
            "p_groundfriction",
            "p_aircontrol",
            "p_sprintBurst",
            "p_sprintSpeed",
            "p_stepheight",
            "p_jumpheight",
            "p_jumpStaminaCost",
            "p_dodgestaminacost",
            "p_staminaDepleteSpeed",
            "p_sprintregenslow",
            "p_sprintRegenFast",
            "p_sprintDeadZone",
            "p_sprintRegainDelay",
            "p_sprintRegainLandDelay",
            "p_maxBlockTime",
            "p_blockSpeed",
            "p_slowWeaponAttack",
            "p_attackingSpeed",
            "p_minslope",
            "p_fallingDamage",
            "p_minfallDamage",
            "sv_maxpush",
            "p_leapUphill",
            "p_leapUphillTime",
            "p_pushRange",
            "p_pushForce",
            "p_grabRange",
            "p_throwForce",
            "sv_quakeMultiplyer"
        };
        HashMap<String,String> config=cman.get(names);
        specSpeedTextField.setText(config.get("p_specspeed"));
        specAccelerationTextField.setText(config.get("p_freeflyAccel"));
        playerSpeedTextField.setText(config.get("p_speed"));
        gravityTextField.setText(config.get("p_gravity"));
        frictionTextField.setText(config.get("p_groundfriction"));
        airControlTextField.setText(config.get("p_aircontrol"));
        if (config.get("p_sprintBurst").equals("1")) sprintBurstCheckBox.setSelected(true);
        else sprintBurstCheckBox.setSelected(false);
        sprintSpeedTextField.setText(config.get("p_sprintSpeed"));
        stepHeightTextField.setText(config.get("p_stepheight"));
        jumpHeightTextField.setText(config.get("p_jumpheight"));
        jumpStaminaCostTextField.setText(config.get("p_jumpStaminaCost"));
        leapStaminaCostTextField.setText(config.get("p_dodgestaminacost"));
        staminaDepleteSpeedTextField.setText(config.get("p_staminaDepleteSpeed"));
        sprintRegenSlowTextField.setText(config.get("p_sprintregenslow"));
        sprintRegenFastTextField.setText(config.get("p_sprintRegenFast"));
        sprintDeadZoneTextField.setText(config.get("p_sprintDeadZone"));
        sprintRegainDelayTextField.setText(config.get("p_sprintRegainDelay"));
        sprintRegainLandDelayTextField.setText(config.get("p_sprintRegainLandDelay"));
        maxBlockTimeTextField.setText(config.get("p_maxBlockTime"));
        blockSpeedTextField.setText(config.get("p_blockSpeed"));
        slowWeaponAttackTextField.setText(config.get("p_slowWeaponAttack"));
        attackingSpeedTextField.setText(config.get("p_attackingSpeed"));
        minSlopeTextField.setText(config.get("p_minslope"));
        if (config.get("p_fallingDamage").equals("1")) fallingDamageCheckBox.setSelected(true);
        else fallingDamageCheckBox.setSelected(false);
        minFallDamage.setText(config.get("p_minFallDamage"));
        maxPushTextField.setText(config.get("sv_maxpush"));
        if (config.get("p_leapUphill").equals("1")) uphillLeapCheckBox.setSelected(true);
        else uphillLeapCheckBox.setSelected(false);
        uphillLeapTimeTextField.setText(config.get("p_leapUphillTime"));
        pushRangeTextField.setText(config.get("p_pushRange"));
        pushForceTextField.setText(config.get("p_pushForce"));
        grabRangeTextField.setText(config.get("p_grabRange"));
        throwForceTextField.setText(config.get("p_throwForce"));
        quakeMultiplierTextField.setText(config.get("sv_quakeMultiplyer"));
    }

    private void onPhysicsApply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("p_specspeed",specSpeedTextField.getText());
        config.put("p_freeflyAccel",specAccelerationTextField.getText());
        config.put("p_speed",playerSpeedTextField.getText());
        config.put("p_gravity",gravityTextField.getText());
        config.put("p_groundfriction",frictionTextField.getText());
        config.put("p_aircontrol",airControlTextField.getText());
        config.put("p_sprintBurst",sprintBurstCheckBox.isSelected()?"1":"0");
        config.put("p_sprintSpeed",sprintSpeedTextField.getText());
        config.put("p_stepheight",stepHeightTextField.getText());
        config.put("p_jumpheight",jumpHeightTextField.getText());
        config.put("p_jumpStaminaCost",jumpStaminaCostTextField.getText());
        config.put("p_dodgestaminacost",leapStaminaCostTextField.getText());
        config.put("p_staminaDepleteSpeed",staminaDepleteSpeedTextField.getText());
        config.put("p_sprintregenslow",sprintRegenSlowTextField.getText());
        config.put("p_sprintRegenFast",sprintRegenFastTextField.getText());
        config.put("p_sprintDeadZone",sprintDeadZoneTextField.getText());
        config.put("p_sprintRegainDelay",sprintRegainDelayTextField.getText());
        config.put("p_sprintRegainLandDelay",sprintRegainLandDelayTextField.getText());
        config.put("p_maxBlockTime",maxBlockTimeTextField.getText());
        config.put("p_blockSpeed",blockSpeedTextField.getText());
        config.put("p_slowWeaponAttack",slowWeaponAttackTextField.getText());
        config.put("p_attackingSpeed",attackingSpeedTextField.getText());
        config.put("p_minslope",minSlopeTextField.getText());
        config.put("p_fallingDamage",fallingDamageCheckBox.isSelected()?"1":"0");
        config.put("p_minfallDamage",minFallDamage.getText());
        config.put("sv_maxpush",maxPushTextField.getText());
        config.put("p_leapUphill",uphillLeapCheckBox.isSelected()?"1":"0");
        config.put("p_leapUphillTime",uphillLeapTimeTextField.getText());
        config.put("p_pushRange",pushRangeTextField.getText());
        config.put("p_pushForce",pushForceTextField.getText());
        config.put("p_grabRange",grabRangeTextField.getText());
        config.put("p_throwForce",throwForceTextField.getText());
        config.put("sv_quakeMultiplyer",quakeMultiplierTextField.getText());
        cman.set(config);
    }

    private void onEnableSquads() {
        if (enableSquadsCheckBox.isSelected()) {
            squadAutoAssignCheckBox.setEnabled(true);
            autoSquadMinimumTextField.setEditable(true);
            squadMembersPerSquadOfficerTextField.setEditable(true);
        }
        else {
            squadAutoAssignCheckBox.setEnabled(false);
            autoSquadMinimumTextField.setEditable(false);
            squadMembersPerSquadOfficerTextField.setEditable(false);
        }
    }

    private void onRepairCosts() {
        if (repairCostsCheckBox.isSelected()) repairCostFactorTextField.setEditable(true);
        else repairCostFactorTextField.setEditable(false);
    }

    private void onAllowItemDropAction() {
        if (allowItemDropActionCheckBox.isSelected()) {
            allowItemDropOnDeathCheckBox.setEnabled(true);
            allowToPickupEnemyCheckBox.setEnabled(true);
            droppedItemExpiryTimeTextField.setEditable(true);
            droppedItemPickupDistanceTextField.setEditable(true);
        }
        else {
            allowItemDropOnDeathCheckBox.setEnabled(false);
            allowToPickupEnemyCheckBox.setEnabled(false);
            droppedItemExpiryTimeTextField.setEditable(false);
            droppedItemPickupDistanceTextField.setEditable(false);
        }
    }

    private void onUphillLeap() {
        if (uphillLeapCheckBox.isSelected()) uphillLeapTimeTextField.setEditable(true);
        else uphillLeapTimeTextField.setEditable(true);
    }

    private void onFallingDamage() {
        if (fallingDamageCheckBox.isSelected()) minFallDamage.setEditable(false);
        else minFallDamage.setEditable(false);
    }

    private void onExperienceReloadData() {
        String[] names={
            "sv_xp_mult",
            "sv_xp_connect",
            "sv_xp_build",
            "sv_xp_repair",
            "sv_xp_mine",
            "sv_xp_kill_npc",
            "sv_xp_kill_worker",
            "sv_xp_kill_player",
            "sv_xp_kill_siege",
            "sv_xp_kill_item",
            "sv_xp_structure_damage",
            "sv_xp_raze",
            "sv_xp_heal_player",
            "sv_xp_revive_player",
            "sv_xp_honor",
            "sv_xp_skill",
            "sv_xp_hero",
            "sv_xp_legend",
            "sv_xp_commander_order_given",
            "sv_xp_commander_order_followed",
            "sv_xp_commander_gather",
            "sv_xp_commander_powerup_given",
            "sv_xp_commander_structure",
            "sv_xp_commander_research",
            "sv_xp_commander_raze"
        };
        HashMap<String,String> config=cman.get(names);
        xpMultiplierTextField.setText(config.get("sv_xp_mult"));
        xpOnConnectTextField.setText(config.get("sv_xp_connect"));
        playerBuildTextField.setText(config.get("sv_xp_build"));
        repairTextField.setText(config.get("sv_xp_repair"));
        mineTextField.setText(config.get("sv_xp_mine"));
        killNPCTextField.setText(config.get("sv_xp_kill_npc"));
        killWorkerTextField.setText(config.get("sv_xp_kill_worker"));
        killPlayerTextField.setText(config.get("sv_xp_kill_player"));
        killSiegeTextField.setText(config.get("sv_xp_kill_siege"));
        killItemTextField.setText(config.get("sv_xp_kill_item"));
        hitBuildingTextField.setText(config.get("sv_xp_structure_damage"));
        lastHitOnBuildingTextField.setText(config.get("sv_xp_raze"));
        healPlayerTextField.setText(config.get("sv_xp_heal_player"));
        revivePlayerTextField.setText(config.get("sv_xp_revive_player"));
        honorTextField.setText(config.get("sv_xp_honor"));
        skillTextField.setText(config.get("sv_xp_skill"));
        heroTextField.setText(config.get("sv_xp_hero"));
        legendTextField.setText(config.get("sv_xp_legend"));
        orderGivenTextField.setText(config.get("sv_xp_commander_order_given"));
        orderFollowedTextField.setText(config.get("sv_xp_commander_order_followed"));
        resourcesGatheredTextField.setText(config.get("sv_xp_commander_gather"));
        powerupGivenTextField.setText(config.get("sv_xp_commander_powerup_given"));
        commanderBuildTextField.setText(config.get("sv_xp_commander_structure"));
        researchTextField.setText(config.get("sv_xp_commander_research"));
        destroyEnemyBuildingTextField.setText(config.get("sv_xp_commander_raze"));
    }

    private void onExperienceApply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_xp_mult",xpMultiplierTextField.getText());
        config.put("sv_xp_connect",xpOnConnectTextField.getText());
        config.put("sv_xp_build",playerBuildTextField.getText());
        config.put("sv_xp_repair",repairTextField.getText());
        config.put("sv_xp_mine",mineTextField.getText());
        config.put("sv_xp_kill_npc",killNPCTextField.getText());
        config.put("sv_xp_kill_worker",killWorkerTextField.getText());
        config.put("sv_xp_kill_player",killPlayerTextField.getText());
        config.put("sv_xp_kill_siege",killSiegeTextField.getText());
        config.put("sv_xp_kill_item",killItemTextField.getText());
        config.put("sv_xp_structure_damage",hitBuildingTextField.getText());
        config.put("sv_xp_raze",lastHitOnBuildingTextField.getText());
        config.put("sv_xp_heal_player",healPlayerTextField.getText());
        config.put("sv_xp_revive_player",revivePlayerTextField.getText());
        config.put("sv_xp_honor",honorTextField.getText());
        config.put("sv_xp_skill",skillTextField.getText());
        config.put("sv_xp_hero",heroTextField.getText());
        config.put("sv_xp_legend",legendTextField.getText());
        config.put("sv_xp_commander_order_given",orderGivenTextField.getText());
        config.put("sv_xp_commander_order_followed",orderFollowedTextField.getText());
        config.put("sv_xp_commander_gather",resourcesGatheredTextField.getText());
        config.put("sv_xp_commander_powerup_given",powerupGivenTextField.getText());
        config.put("sv_xp_commander_structure",commanderBuildTextField.getText());
        config.put("sv_xp_commander_research",researchTextField.getText());
        config.put("sv_xp_commander_raze",destroyEnemyBuildingTextField.getText());
        cman.set(config);
    }

    private void onResourcesReloadData() {
        String[] names={
            "sv_startingTeamStone",
            "sv_startingTeamGold",
            "sv_clientConnectMoney",
            "sv_maxMoney",
            "sv_reviveMoneyReward",
            "sv_ignoreMoney",
            "sv_goodieBags",
            "sv_goodiesForAll",
            "sv_goodieDuration",
            "sv_goodieMeOnlyTime",
            "sv_goodieMaxMoney",
            "sv_goodieBigMoneyChance",
            "sv_goodieAmmoChance",
            "sv_allowWorkAnims",
            "sv_mineDepletion",
            "sv_enableTithe"
        };
        HashMap<String,String> config=cman.get(names);
        startingStoneTextField.setText(config.get("sv_startingTeamStone"));
        startingGoldTextField.setText(config.get("sv_startingTeamGold"));
        connectMoneyTextField.setText(config.get("sv_clientConnectMoney"));
        maxMoneyTextField.setText(config.get("sv_maxMoney"));
        reviveMoneyRewardTextField.setText(config.get("sv_reviveMoneyReward"));
        if (config.get("sv_ignoreMoney").equals("1")) buyStuffForFreeCheckBox.setSelected(true);
        else buyStuffForFreeCheckBox.setSelected(false);
        if (config.get("sv_goodieBags").equals("1")) enableGoodieBagsCheckBox.setSelected(true);
        else enableGoodieBagsCheckBox.setSelected(false);
        allowPickupComboBox.setSelectedIndex(Integer.parseInt(config.get("sv_goodiesForAll")));
        durationTextField.setText(config.get("sv_goodieDuration"));
        playerOnlyTimeTextField.setText(config.get("sv_goodieMeOnlyTime"));
        maxValueTextField.setText(config.get("sv_goodieMaxMoney"));
        jackpotChanceTextField.setText(config.get("sv_goodieBigMoneyChance"));
        ammoChanceTextField.setText(config.get("sv_goodieAmmoChance"));
        if (config.get("sv_allowWorkAnims").equals("1")) allowWorkAnimationsCheckBox.setSelected(true);
        else allowWorkAnimationsCheckBox.setSelected(false);
        if (config.get("sv_mineDepletion").equals("1")) allowMineDepletionCheckBox.setSelected(true);
        else allowMineDepletionCheckBox.setSelected(false);
        if (config.get("sv_enableTithe").equals("1")) allowTaxChangeCheckBox.setSelected(true);
        else allowTaxChangeCheckBox.setSelected(false);
    }

    private void onResourcesApply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_startingTeamStone",startingStoneTextField.getText());
        config.put("sv_startingTeamGold",startingGoldTextField.getText());
        config.put("sv_clientConnectMoney",connectMoneyTextField.getText());
        config.put("sv_maxMoney",maxMoneyTextField.getText());
        config.put("sv_reviveMoneyReward",reviveMoneyRewardTextField.getText());
        config.put("sv_ignoreMoney",buyStuffForFreeCheckBox.isSelected()?"1":"0");
        config.put("sv_goodieBags",enableGoodieBagsCheckBox.getText());
        config.put("sv_goodiesForAll",""+allowPickupComboBox.getSelectedIndex());
        config.put("sv_goodieDuration",durationTextField.getText());
        config.put("sv_goodieMeOnlyTime",playerOnlyTimeTextField.getText());
        config.put("sv_goodieMaxMoney",maxValueTextField.getText());
        config.put("sv_goodieBigMoneyChance",jackpotChanceTextField.getText());
        config.put("sv_goodieAmmoChance",ammoChanceTextField.getText());
        config.put("sv_allowWorkAnims",allowWorkAnimationsCheckBox.isSelected()?"1":"0");
        config.put("sv_mineDepletion",allowMineDepletionCheckBox.isSelected()?"1":"0");
        config.put("sv_enableTithe",allowTaxChangeCheckBox.isSelected()?"1":"0");
        cman.set(config);
    }

    private void enableGoodieBags() {
        if (enableGoodieBagsCheckBox.isSelected()) {
            allowPickupComboBox.setEnabled(true);
            durationTextField.setEditable(true);
            playerOnlyTimeTextField.setEditable(true);
        }
        else {
            allowPickupComboBox.setEnabled(false);
            durationTextField.setEditable(false);
            playerOnlyTimeTextField.setEditable(false);
        }
    }

    private void onDisableVotes() {
        if (disableVotingCheckBox.isSelected()) {
            voteDurationTextField.setEditable(false);
            minVotePercentTextField.setEditable(false);
            forceCommanderPlayerLimitTextField.setEditable(false);
            concedeVotesCheckBox.setEnabled(false);
            drawVotesCheckBox.setEnabled(false);
            electVotesCheckBox.setEnabled(false);
            impeachVotesCheckBox.setEnabled(false);
            kickVotesCheckBox.setEnabled(false);
            mapVotesCheckBox.setEnabled(false);
            messageVotesCheckBox.setEnabled(false);
            muteVotesCheckBox.setEnabled(false);
            nextMapVotesCheckBox.setEnabled(false);
            modVotesCheckBox.setEnabled(false);
            pauseVotesCheckBox.setEnabled(false);
            unpauseVotesCheckBox.setEnabled(false);
            raceVotesCheckBox.setEnabled(false);
            refVotesCheckBox.setEnabled(false);
            restartVotesCheckBox.setEnabled(false);
            shuffleVotesCheckBox.setEnabled(false);
            timeVotesCheckBox.setEnabled(false);
            demoRecordVotesCheckBox.setEnabled(false);
            demoReplayVotesCheckBox.setEnabled(false);
        }
        else {
            voteDurationTextField.setEnabled(true);
            minVotePercentTextField.setEnabled(true);
            forceCommanderPlayerLimitTextField.setEnabled(true);
            concedeVotesCheckBox.setEnabled(true);
            drawVotesCheckBox.setEnabled(true);
            electVotesCheckBox.setEnabled(true);
            impeachVotesCheckBox.setEnabled(true);
            kickVotesCheckBox.setEnabled(true);
            mapVotesCheckBox.setEnabled(true);
            messageVotesCheckBox.setEnabled(true);
            muteVotesCheckBox.setEnabled(true);
            nextMapVotesCheckBox.setEnabled(true);
            modVotesCheckBox.setEnabled(true);
            pauseVotesCheckBox.setEnabled(true);
            unpauseVotesCheckBox.setEnabled(true);
            raceVotesCheckBox.setEnabled(true);
            refVotesCheckBox.setEnabled(true);
            restartVotesCheckBox.setEnabled(true);
            shuffleVotesCheckBox.setEnabled(true);
            timeVotesCheckBox.setEnabled(true);
            demoRecordVotesCheckBox.setEnabled(true);
            demoReplayVotesCheckBox.setEnabled(true);
        }
    }

    private void onVotesReloadData() {
        String[] names={
            "sv_disableVoting",
            "sv_voteduration",
            "sv_minVotePercent",
            "sv_electcommanders",
            "sv_allowConcedeVotes",
            "sv_allowDrawVotes",
            "sv_allowElectVotes",
            "sv_allowImpeachVotes",
            "sv_allowKickVotes",
            "sv_allowMapVotes",
            "sv_allowMsgVotes",
            "sv_allowMuteVotes",
            "sv_allowNextMapVotes",
            "sv_allowModVotes",
            "sv_allowPauseVotes",
            "sv_allowUnPauseVotes",
            "sv_allowRaceVotes",
            "sv_allowRefVotes",
            "sv_allowRestartVotes",
            "sv_allowShuffleVotes",
            "sv_allowTimeVotes",
            "sv_allowrecordvotes",
            "sv_allowreplayvotes"
        };
        HashMap<String,String> config=cman.get(names);
        if (config.get("sv_disableVoting").equals("1")) disableVotingCheckBox.setSelected(true);
        else disableVotingCheckBox.setSelected(false);
        voteDurationTextField.setText(config.get("sv_voteduration"));
        minVotePercentTextField.setText(config.get("sv_minVotePercent"));
        forceCommanderPlayerLimitTextField.setText(config.get("sv_electcommanders"));
        if (config.get("sv_allowConcedeVotes").equals("1")) concedeVotesCheckBox.setSelected(true);
        else concedeVotesCheckBox.setSelected(false);
        if (config.get("sv_allowDrawVotes").equals("1")) drawVotesCheckBox.setSelected(true);
        else drawVotesCheckBox.setSelected(false);
        if (config.get("sv_allowElectVotes").equals("1")) electVotesCheckBox.setSelected(true);
        else electVotesCheckBox.setSelected(false);
        if (config.get("sv_allowImpeachVotes").equals("1")) impeachVotesCheckBox.setSelected(true);
        else impeachVotesCheckBox.setSelected(false);
        if (config.get("sv_allowKickVotes").equals("1")) kickVotesCheckBox.setSelected(true);
        else kickVotesCheckBox.setSelected(false);
        if (config.get("sv_allowMapVotes").equals("1")) mapVotesCheckBox.setSelected(true);
        else mapVotesCheckBox.setSelected(false);
        if (config.get("sv_allowMsgVotes").equals("1")) messageVotesCheckBox.setSelected(true);
        else messageVotesCheckBox.setSelected(false);
        if (config.get("sv_allowMuteVotes").equals("1")) muteVotesCheckBox.setSelected(true);
        else muteVotesCheckBox.setSelected(false);
        if (config.get("sv_allowNextMapVotes").equals("1")) nextMapVotesCheckBox.setSelected(true);
        else nextMapVotesCheckBox.setSelected(false);
        if (config.get("sv_allowModVotes").equals("1")) modVotesCheckBox.setSelected(true);
        else modVotesCheckBox.setSelected(false);
        if (config.get("sv_allowPauseVotes").equals("1")) pauseVotesCheckBox.setSelected(true);
        else pauseVotesCheckBox.setSelected(false);
        if (config.get("sv_allowUnPauseVotes").equals("1")) unpauseVotesCheckBox.setSelected(true);
        else unpauseVotesCheckBox.setSelected(false);
        if (config.get("sv_allowRaceVotes").equals("1")) raceVotesCheckBox.setSelected(true);
        else raceVotesCheckBox.setSelected(false);
        if (config.get("sv_allowRefVotes").equals("1")) refVotesCheckBox.setSelected(true);
        else refVotesCheckBox.setSelected(false);
        if (config.get("sv_allowRestartVotes").equals("1")) restartVotesCheckBox.setSelected(true);
        else restartVotesCheckBox.setSelected(false);
        if (config.get("sv_allowShuffleVotes").equals("1")) shuffleVotesCheckBox.setSelected(true);
        else shuffleVotesCheckBox.setSelected(false);
        if (config.get("sv_allowTimeVotes").equals("1")) timeVotesCheckBox.setSelected(true);
        else timeVotesCheckBox.setSelected(false);
        if (config.get("sv_allowrecordvotes").equals("1")) demoRecordVotesCheckBox.setSelected(true);
        else demoRecordVotesCheckBox.setSelected(false);
        if (config.get("sv_allowreplayvotes").equals("1")) demoReplayVotesCheckBox.setSelected(true);
        else demoReplayVotesCheckBox.setSelected(false);
    }

    private void onVotesApply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_disableVoting",disableVotingCheckBox.isSelected()?"1":"0");
        config.put("sv_voteduration",voteDurationTextField.getText());
        config.put("sv_minVotePercent",minVotePercentTextField.getText());
        config.put("sv_electcommanders",forceCommanderPlayerLimitTextField.getText());
        config.put("sv_allowConcedeVotes",concedeVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowDrawVotes",drawVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowElectVotes",electVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowImpeachVotes",impeachVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowKickVotes",kickVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowMapVotes",mapVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowMsgVotes",messageVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowMuteVotes",muteVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowNextMapVotes",nextMapVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowModVotes",modVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowPauseVotes",pauseVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowUnPauseVotes",unpauseVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowRaceVotes",raceVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowRefVotes",refVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowRestartVotes",restartVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowShuffleVotes",shuffleVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowTimeVotes",timeVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowrecordvotes",demoRecordVotesCheckBox.isSelected()?"1":"0");
        config.put("sv_allowreplayvotes",demoReplayVotesCheckBox.isSelected()?"1":"0");
        cman.set(config);
    }

    private void onTeamDamage() {
        if (allowTeamDamageCheckBox.isSelected()) {
            allowMeleeTeamDamageCheckBox.setEnabled(true);
            allowWeaponTeamDamageCheckBox.setEnabled(true);
            allowSiegeTeamDamageCheckBox.setEnabled(true);
            allowTowerTeamDamageCheckBox.setEnabled(true);
            allowItemTeamDamageCheckBox.setEnabled(true);
            teamDamagePercentTextField.setEditable(true);
        }
        else {
            allowMeleeTeamDamageCheckBox.setEnabled(false);
            allowWeaponTeamDamageCheckBox.setEnabled(false);
            allowSiegeTeamDamageCheckBox.setEnabled(false);
            allowTowerTeamDamageCheckBox.setEnabled(false);
            allowItemTeamDamageCheckBox.setEnabled(false);
            teamDamagePercentTextField.setEditable(false);
        }

    }

    private void onReplayDemos() {
        if (replayDemosCheckBox.isSelected()) recordDemosCheckBox.setSelected(false);
    }

    private void onRecordDemos() {
        if (recordDemosCheckBox.isSelected()) replayDemosCheckBox.setSelected(false);
    }

    private void onAdvanced2ReloadData() {
        String[] names={
            "sv_placebuildingtestscale",
            "sv_claimableBuildings",
            "sv_minClaimInterval",
            "sv_repairCost",
            "sv_repairMult",
            "sv_buildingDmgScale",
            "sv_overtime_decay",
            "sv_zeroRelocVelocity",
            "sv_landminedistance",
            "sv_projRestVelocity",
            "sv_projRestSlope",
            "sv_allowItemDropAction",
            "sv_allowItemDropDeath",
            "sv_allowItemPickEnemy",
            "sv_itemDropDuration",
            "sv_itemPickDistance",
            "sv_teamDamage",
            "sv_teamMeleeDamage",
            "sv_teamWeaponDamage",
            "sv_teamSiegeDamage",
            "sv_teamBuildingDamage",
            "sv_teamItemDamage",
            "sv_teamDamagePercent",
            "serverdemos_recordserver",
            "serverdemos_replayserver",
            "sv_allowlistdemos",
            "serverdemos_dir",
            "serverdemos_savedir"
        };
        HashMap<String,String> config=cman.get(names);
        buildingTestScaleTextField.setText(config.get("sv_placebuildingtestscale"));
        if (config.get("sv_claimableBuildings").equals("1")) claimableBuildingsCheckBox.setSelected(true);
        else claimableBuildingsCheckBox.setSelected(false);
        minClaimIntervalTextField.setText(config.get("sv_minClaimInterval"));
        if (config.get("sv_repairCost").equals("1")) repairCostsCheckBox.setSelected(true);
        else repairCostsCheckBox.setSelected(false);
        repairCostFactorTextField.setText(config.get("sv_repairMult"));
        buildingDamageRateTextField.setText(config.get("sv_buildingDmgScale"));
        if (config.get("sv_overtime_decay").equals("1")) overtimeDecayCheckBox.setSelected(true);
        else overtimeDecayCheckBox.setSelected(false);
        if (config.get("sv_zeroRelocVelocity").equals("1")) preventRelocExploitsCheckBox.setSelected(true);
        else preventRelocExploitsCheckBox.setSelected(false);
        minLandmineDistanceTextField.setText(config.get("sv_landminedistance"));
        bouncingProjectileRestVelocityTextField.setText(config.get("sv_projRestVelocity"));
        bouncingProjectileRestSlopeTextField.setText(config.get("sv_projRestSlope"));
        if (config.get("sv_allowItemDropAction").equals("1")) allowItemDropActionCheckBox.setSelected(true);
        else allowItemDropActionCheckBox.setSelected(false);
        if (config.get("sv_allowItemDropDeath").equals("1")) allowItemDropOnDeathCheckBox.setSelected(true);
        else allowItemDropOnDeathCheckBox.setSelected(false);
        if (config.get("sv_allowItemPickEnemy").equals("1")) allowToPickupEnemyCheckBox.setSelected(true);
        else allowToPickupEnemyCheckBox.setSelected(false);
        droppedItemExpiryTimeTextField.setText(config.get("sv_itemDropDuration"));
        droppedItemPickupDistanceTextField.setText(config.get("sv_itemPickDistance"));
        if (config.get("sv_teamDamage").equals("1")) allowTeamDamageCheckBox.setSelected(true);
        else allowTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamMeleeDamage").equals("1")) allowMeleeTeamDamageCheckBox.setSelected(true);
        else allowMeleeTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamWeaponDamage").equals("1")) allowWeaponTeamDamageCheckBox.setSelected(true);
        else allowWeaponTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamSiegeDamage").equals("1")) allowSiegeTeamDamageCheckBox.setSelected(true);
        else allowSiegeTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamBuildingDamage").equals("1")) allowTowerTeamDamageCheckBox.setSelected(true);
        else allowTowerTeamDamageCheckBox.setSelected(false);
        if (config.get("sv_teamItemDamage").equals("1")) allowItemTeamDamageCheckBox.setSelected(true);
        else allowItemTeamDamageCheckBox.setSelected(false);
        teamDamagePercentTextField.setText(config.get("sv_teamDamagePercent"));
        if (config.get("serverdemos_recordserver").equals("1")) recordDemosCheckBox.setSelected(true);
        else recordDemosCheckBox.setSelected(false);
        if (config.get("serverdemos_replayserver").equals("1")) replayDemosCheckBox.setSelected(true);
        else replayDemosCheckBox.setSelected(false);
        if (config.get("sv_allowlistdemos").equals("1")) allowDemoListingCheckBox.setSelected(true);
        else allowDemoListingCheckBox.setSelected(false);
        replayFolderTextField.setText(config.get("serverdemos_dir"));
        demoFolderTextField.setText(config.get("serverdemos_savedir"));
    }

    private void onAdvanced2Apply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_placebuildingtestscale",buildingTestScaleTextField.getText());
        config.put("sv_claimableBuildings",claimableBuildingsCheckBox.isSelected()?"1":"0");
        config.put("sv_minClaimInterval",minClaimIntervalTextField.getText());
        config.put("sv_repairCost",repairCostsCheckBox.isSelected()?"1":"0");
        config.put("sv_repairMult",repairCostFactorTextField.getText());
        config.put("sv_buildingDmgScale",buildingDamageRateTextField.getText());
        config.put("sv_overtime_decay",overtimeDecayCheckBox.isSelected()?"1":"0");
        config.put("sv_zeroRelocVelocity",preventRelocExploitsCheckBox.isSelected()?"1":"0");
        config.put("sv_landminedistance",minLandmineDistanceTextField.getText());
        config.put("sv_projRestVelocity",bouncingProjectileRestVelocityTextField.getText());
        config.put("sv_projRestSlope",bouncingProjectileRestSlopeTextField.getText());
        config.put("sv_allowItemDropAction",allowItemDropActionCheckBox.isSelected()?"1":"0");
        config.put("sv_allowItemDropDeath",allowItemDropOnDeathCheckBox.isSelected()?"1":"0");
        config.put("sv_allowItemPickEnemy",allowToPickupEnemyCheckBox.isSelected()?"1":"0");
        config.put("sv_itemDropDuration",droppedItemExpiryTimeTextField.getText());
        config.put("sv_itemPickDistance",droppedItemPickupDistanceTextField.getText());
        config.put("sv_teamDamage",allowTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamMeleeDamage",allowMeleeTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamWeaponDamage",allowWeaponTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamSiegeDamage",allowSiegeTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamBuildingDamage",allowTowerTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamItemDamage",allowItemTeamDamageCheckBox.isSelected()?"1":"0");
        config.put("sv_teamDamagePercent",teamDamagePercentTextField.getText());
        config.put("serverdemos_recordserver",recordDemosCheckBox.isSelected()?"1":"0");
        config.put("serverdemos_replayserver",replayDemosCheckBox.isSelected()?"1":"0");
        config.put("sv_allowlistdemos",allowDemoListingCheckBox.isSelected()?"1":"0");
        config.put("serverdemos_dir",replayFolderTextField.getText());
        config.put("serverdemos_savedir",demoFolderTextField.getText());
        cman.set(config);
    }

    private void onAdvanced1ReloadData() {
        String[] names={
                "sv_readyPercent",
                "sv_allowWarmupAllSpawnLocs",
                "sv_allowWarmupInfiniteGold",
                "svr_voipAllowAnyone",
                "svr_voipAllowOfficer",
                "svr_voipAllowCommander",
                "svr_voipTargetGlobal",
                "svr_voipTargetTeam",
                "svr_voipTargetSquad",
                "svr_voipStreamTime",
                "svr_voipStreamWait",
                "g_maxofficers",
                "g_clientsperofficer",
                "sv_enablesquads",
                "sv_autoSquadClients",
                "sv_autoSquadMinimum",
                "g_squadminperofficer",
                "sv_teamSwitchDelay",
                "sv_teamSwitchConnectFreedom",
                "sv_respawntime",
                "sv_ressurectTime",
                "sv_invincibleTime",
                "sv_invincibleTime_respawn",
                "sv_skillfullKillDist",
                "sv_blockArcMult"
        };
        HashMap<String,String> config=cman.get(names);
        readyPercentTextField.setText(config.get("sv_readyPercent"));
        if (config.get("sv_allowWarmupAllSpawnLocs").equals("1")) allowSpawningAtAllCheckBox.setSelected(true);
        else allowSpawningAtAllCheckBox.setSelected(false);
        if (config.get("sv_allowWarmupInfiniteGold").equals("1")) infiniteGoldAtWarmupCheckBox.setSelected(true);
        else infiniteGoldAtWarmupCheckBox.setSelected(false);
        if (config.get("svr_voipAllowAnyone").equals("1")) allowAnyoneCheckBox.setSelected(true);
        else allowAnyoneCheckBox.setSelected(false);
        if (config.get("svr_voipAllowOfficer").equals("1")) allowOfficersCheckBox.setSelected(true);
        else allowOfficersCheckBox.setSelected(false);
        if (config.get("svr_voipAllowCommander").equals("1")) allowCommandersCheckBox.setSelected(true);
        else allowCommandersCheckBox.setSelected(false);
        if (config.get("svr_voipTargetGlobal").equals("1")) allowGlobalVOIPChattingCheckBox.setSelected(true);
        else allowGlobalVOIPChattingCheckBox.setSelected(false);
        if (config.get("svr_voipTargetTeam").equals("1")) allowTeamVOIPChattingCheckBox.setSelected(true);
        else allowTeamVOIPChattingCheckBox.setSelected(false);
        if (config.get("svr_voipTargetSquad").equals("1")) allowSquadVOIPChattingCheckBox.setSelected(true);
        else allowSquadVOIPChattingCheckBox.setSelected(false);
        maxStreamTimeTextField.setText(config.get("svr_voipStreamTime"));
        streamWaitTimeTextField.setText(config.get("svr_voipStreamWait"));
        maxOfficerTextField.setText(config.get("g_maxofficers"));
        clientsPerOfficerTextField.setText(config.get("g_clientsperofficer"));
        if (config.get("sv_enablesquads").equals("1")) enableSquadsCheckBox.setSelected(true);
        else enableSquadsCheckBox.setSelected(false);
        if (config.get("sv_autoSquadClients").equals("1")) squadAutoAssignCheckBox.setSelected(true);
        else squadAutoAssignCheckBox.setSelected(false);
        autoSquadMinimumTextField.setText(config.get("sv_autoSquadMinimum"));
        squadMembersPerSquadOfficerTextField.setText(config.get("g_squadminperofficer"));
        teamSwitchDelayTextField.setText(config.get("sv_teamSwitchDelay"));
        teamSwitchFreedomTextField.setText(config.get("sv_teamSwitchConnectFreedom"));
        respawnTimeTextField.setText(config.get("sv_respawntime"));
        resurrectTimeTextField.setText(config.get("sv_ressurectTime"));
        invincibleTimeTextField.setText(config.get("sv_invincibleTime"));
        invincibleTimeRespawnFactorTextField.setText(config.get("sv_invincibleTime_respawn"));
        skillfullKillDistanceTextField.setText(config.get("sv_skillfullKillDist"));
        blockArcMultiplierTextField.setText(config.get("sv_blockArcMult"));
    }

    private void onAdvanced1Apply() {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("sv_readyPercent",readyPercentTextField.getText());
        config.put("sv_allowWarmupAllSpawnLocs",allowSpawningAtAllCheckBox.isSelected()?"1":"0");
        config.put("sv_allowWarmupInfiniteGold",infiniteGoldAtWarmupCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowAnyone",allowAnyoneCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowOfficer",allowOfficersCheckBox.isSelected()?"1":"0");
        config.put("svr_voipAllowCommander",allowCommandersCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetGlobal",allowGlobalVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetTeam",allowTeamVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipTargetSquad",allowSquadVOIPChattingCheckBox.isSelected()?"1":"0");
        config.put("svr_voipStreamTime",maxStreamTimeTextField.getText());
        config.put("svr_voipStreamWait",streamWaitTimeTextField.getText());
        config.put("g_maxofficers",maxOfficerTextField.getText());
        config.put("g_clientsperofficer",clientsPerOfficerTextField.getText());
        config.put("sv_enablesquads",enableSquadsCheckBox.isSelected()?"1":"0");
        config.put("sv_autoSquadClients",squadAutoAssignCheckBox.isSelected()?"1":"0");
        config.put("sv_autoSquadMinimum",autoSquadMinimumTextField.getText());
        config.put("g_squadminperofficer",squadMembersPerSquadOfficerTextField.getText());
        config.put("sv_teamSwitchDelay",teamSwitchDelayTextField.getText());
        config.put("sv_teamSwitchConnectFreedom",teamSwitchFreedomTextField.getText());
        config.put("sv_respawntime",respawnTimeTextField.getText());
        config.put("sv_ressurectTime",resurrectTimeTextField.getText()); //TODO: Schauen ob Variable nicht sv_resurrectTime stattdessen heißt!
        config.put("sv_invincibleTime",invincibleTimeTextField.getText());
        config.put("sv_invincibleTime_respawn",invincibleTimeRespawnFactorTextField.getText());
        config.put("sv_skillfullKillDist",skillfullKillDistanceTextField.getText());
        config.put("sv_blockArcMult",blockArcMultiplierTextField.getText());
        cman.set(config);
    }

    private void onGeneralReloadData() {
        String[] names={
                "svr_name",
                "sv_serverNotes",
                "svr_maxclients",
                "sv_balancedTeams",
                "svr_broadcast",
                "sv_sendStatsSEP",
                "svr_password",
                "svr_PasswordNoVIP",
                "svr_adminpassword",
                "sv_refereePassword",
                "sv_refGodPassword",
                "sv_team1race",
                "sv_team2race",
                "sv_team3race",
                "sv_team4race",
                "sv_team5race",
                "sv_team6race",
                "sv_motd1",
                "sv_motd2",
                "sv_motd3",
                "sv_motd4",
                "sv_motd5",
                "sv_motd6",
        };
        HashMap<String,String> config=cman.get(names);
        serverNameTextField.setText(config.get("svr_name"));
        serverNotesTextField.setText(config.get("sv_serverNotes"));
        maxPlayersTextField.setText(config.get("svr_maxclients"));
        if (config.get("sv_balancedTeams").equals("1")) balancedTeamsCheckBox.setSelected(true);
        else balancedTeamsCheckBox.setSelected(false);
        if (config.get("svr_broadcast").equals("1")) broadcastServerCheckBox.setSelected(true);
        else broadcastServerCheckBox.setSelected(false);
        if (config.get("sv_sendStatsSEP").equals("1")) sendStatsCheckBox.setSelected(true);
        else sendStatsCheckBox.setSelected(false);
        joinPasswordTextField.setText(config.get("svr_password"));
        adminPasswordTextField.setText(config.get("svr_adminpassword"));
        refereePasswordTextField.setText(config.get("sv_refereePassword"));
        godRefPasswordTextField.setText("sv_refGodPassword");
        if (config.get("sv_team1race").equals("beast")) team1ComboBox.setSelectedIndex(0);
        else team1ComboBox.setSelectedIndex(1);
        if (config.get("sv_team2race").equals("beast")) team2ComboBox.setSelectedIndex(0);
        else team2ComboBox.setSelectedIndex(1);
        if (config.get("sv_team3race").equals("beast")) team3ComboBox.setSelectedIndex(0);
        else team3ComboBox.setSelectedIndex(1);
        if (config.get("sv_team4race").equals("beast")) team4ComboBox.setSelectedIndex(0);
        else team4ComboBox.setSelectedIndex(1);
        motd1TextField.setText(config.get("sv_motd1"));
        motd2TextField.setText(config.get("sv_motd2"));
        motd3TextField.setText(config.get("sv_motd3"));
        motd4TextField.setText(config.get("sv_motd4"));
        motd5TextField.setText(config.get("sv_motd5"));
        motd6TextField.setText(config.get("sv_motd6"));
    }

    private void onGeneralApply() {
        HashMap<String,String> config=new HashMap<String,String>();
        config.put("svr_name",serverNameTextField.getText());
        config.put("sv_serverNotes",serverNotesTextField.getText());
        config.put("svr_maxclients",maxPlayersTextField.getText());
        config.put("sv_balancedTeams",balancedTeamsCheckBox.isSelected()?"1":"0");
        config.put("svr_broadcast",broadcastServerCheckBox.isSelected()?"1":"0");
        config.put("sv_sendStatsSEP",sendStatsCheckBox.isSelected()?"1":"0");
        config.put("svr_password",joinPasswordTextField.getText());
        config.put("svr_PasswordNoVIP",joinPasswordTextField.getText());
        config.put("svr_adminpassword",adminPasswordTextField.getText());
        config.put("sv_refereePassword",refereePasswordTextField.getText());
        config.put("sv_refGodPassword",godRefPasswordTextField.getText());
        if (team1ComboBox.getSelectedIndex()==0) config.put("sv_team1race","beast");
        else config.put("sv_team1race","human");
        if (team2ComboBox.getSelectedIndex()==0) config.put("sv_team2race","beast");
        else config.put("sv_team2race","human");
        if (team3ComboBox.getSelectedIndex()==0) config.put("sv_team3race","beast");
        else config.put("sv_team3race","human");
        if (team4ComboBox.getSelectedIndex()==0) config.put("sv_team4race","beast");
        else config.put("sv_team4race","human");
        config.put("sv_motd1",motd1TextField.getText());
        config.put("sv_motd2",motd2TextField.getText());
        config.put("sv_motd3",motd3TextField.getText());
        config.put("sv_motd4",motd4TextField.getText());
        config.put("sv_motd5",motd5TextField.getText());
        config.put("sv_motd6",motd6TextField.getText());
        cman.set(config);
    }

    private void onNextMap() {
        cman.nextmap();
    }

    private void onUnpause() {
        cman.execute("unpause");
    }

    private void onPause() {
        cman.execute("pause");
    }

    private void onRestartMatch() {
        cman.execute("restartmatch");
    }

    private void onLogOut() {
        cman=null;
        dispose();
        new LoginForm();
    }

    private void onExtendTime() {
       cman.execute("time");
    }

    private void onDraw() {
        cman.execute("draw");
    }

    private void onBroadcastMessageSend() {
        cman.execute("svchat \""+broadcastMessageTextField.getText()+"\"");
    }
}
