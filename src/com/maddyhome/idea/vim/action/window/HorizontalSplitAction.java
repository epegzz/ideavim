/*
 * IdeaVim - Vim emulator for IDEs based on the IntelliJ platform
 * Copyright (C) 2003-2019 The IdeaVim authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.maddyhome.idea.vim.action.window;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.maddyhome.idea.vim.VimPlugin;
import com.maddyhome.idea.vim.action.VimCommandAction;
import com.maddyhome.idea.vim.command.Command;
import com.maddyhome.idea.vim.command.MappingMode;
import com.maddyhome.idea.vim.handler.EditorActionHandlerBase;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;
import java.util.Set;

/**
 * @author rasendubi
 */
final public class HorizontalSplitAction extends VimCommandAction {
  @Contract(" -> new")
  @NotNull
  @Override
  final protected EditorActionHandler makeActionHandler() {
    return new EditorActionHandlerBase() {
      @Override
      protected boolean execute(@NotNull Editor editor, @NotNull DataContext context, @NotNull Command cmd) {
        VimPlugin.getWindow().splitWindowHorizontal(context, "");
        return true;
      }
    };
  }

  @Contract(pure = true)
  @NotNull
  @Override
  final public Set<MappingMode> getMappingModes() {
    return MappingMode.N;
  }

  @NotNull
  @Override
  final public Set<List<KeyStroke>> getKeyStrokesSet() {
    return parseKeysSet("<C-W>s", "<C-W>S", "<C-W><C-S>");
  }

  @Contract(pure = true)
  @NotNull
  @Override
  final public Command.Type getType() {
    return Command.Type.OTHER_READONLY;
  }
}
