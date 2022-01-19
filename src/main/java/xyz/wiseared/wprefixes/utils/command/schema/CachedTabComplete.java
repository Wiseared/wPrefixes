package xyz.wiseared.wprefixes.utils.command.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.wiseared.wprefixes.utils.command.adapters.ParameterAdapter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CachedTabComplete {
    @Nullable
    final ParameterAdapter<?> parameterAdapter;

    @NotNull
    final List<String> constant;
}
